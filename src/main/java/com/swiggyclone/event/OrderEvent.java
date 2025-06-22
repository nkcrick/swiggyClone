package com.swiggyclone.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderEvent {
    private String orderId;
    private String status;
}