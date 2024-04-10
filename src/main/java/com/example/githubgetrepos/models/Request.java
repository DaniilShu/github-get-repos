package com.example.githubgetrepos.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
}
