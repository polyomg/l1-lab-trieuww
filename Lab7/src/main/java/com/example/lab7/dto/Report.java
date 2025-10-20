package com.example.lab7.dto;

import java.io.Serializable;

public interface Report extends Serializable {
    Serializable getGroup();
    Double getSum();
    Long getCount();
}
