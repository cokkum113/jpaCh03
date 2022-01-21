package com.example.order;

import com.example.order.Entity.Member;
import com.example.order.Entity.Orders;
import com.example.order.dto.*;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/v1/product")
    public ProductResponse saveProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductName(productResponse.getProductName());
        productResponse.setPrice(productRequest.getPrice());

        Long productId = orderService.createProduct(productRequest.getProductName(), productRequest.getPrice());
        productResponse.setProductId(productId);

        return productResponse;
    }

    @PostMapping("/v1/member")
    public MemberRes saveMember(@RequestBody MemberReq memberReq) {
        MemberRes memberRes = new MemberRes();
        memberRes.setName(memberReq.getName());
        Long memberId = orderService.createMember(memberReq.getName());
        memberRes.setMemberId(memberId);
        return memberRes;
    }

    @PostMapping("/v1/order")
    public void saveOrder(@RequestBody OrderRequest orderRequest) {


    }

    @GetMapping("/v1/order/{orderId}")
    public Orders findOrder(@PathVariable Long orderId){
        return orderService.findOrder(orderId);
    }

    @GetMapping("/v1/order")
    public List<Orders> findOrders(){
        return orderService.findAllOrders();
    }




}
