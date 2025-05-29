package com.data.controller;

import com.data.model.ProductB2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductB2Controller {

    // Trang nhập thông tin sản phẩm
    @GetMapping("/product")
    public String productForm(Model model) {
        model.addAttribute("product", new ProductB2());
        return "product_form";
    }

    // Thêm sản phẩm và lưu vào cookie
    @PostMapping("/add-product")
    public String addProduct(ProductB2 product, HttpServletResponse response) {
        try {
            // Ghép thông tin sản phẩm thành chuỗi
            String rawValue = product.getId() + "_" + product.getProductName() + "_" + product.getPrice();
            // Mã hóa để tránh lỗi ký tự không hợp lệ
            String encodedValue = URLEncoder.encode(rawValue, StandardCharsets.UTF_8.toString());

            // Tạo tên cookie theo ID sản phẩm
            String cookieName = "product_" + product.getId();
            Cookie cookie = new Cookie(cookieName, encodedValue);
            cookie.setMaxAge(24 * 60 * 60); // 1 ngày
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/list-product";
    }

    // Xóa sản phẩm khỏi cookie
    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable int id, HttpServletResponse response) {
        String cookieName = "product_" + id;
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0); // Xóa cookie
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/list-product";
    }


    @GetMapping("/list-product")
    public String listProducts(Model model, HttpServletRequest request) {
        List<ProductB2> products = getProductListFromCookies(request);
        model.addAttribute("products", products);
        return "list_product";
    }

    // Hàm hỗ trợ đọc cookie và chuyển sang danh sách sản phẩm
    private List<ProductB2> getProductListFromCookies(HttpServletRequest request) {
        List<ProductB2> list = new ArrayList<>();
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // Chỉ xử lý cookie có tên bắt đầu bằng "product_"
                if (cookie.getName().startsWith("product_")) {
                    try {
                        String decodedValue = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8.toString());
                        String[] info = decodedValue.split("_");

                        if (info.length == 3) {
                            ProductB2 product = new ProductB2();
                            product.setId(Integer.parseInt(info[0]));
                            product.setProductName(info[1]);
                            product.setPrice(Double.parseDouble(info[2]));
                            list.add(product);
                        }
                    } catch (Exception e) {
                        e.printStackTrace(); // Bỏ qua lỗi nếu có cookie không hợp lệ
                    }
                }
            }
        }

        return list;
    }
}
