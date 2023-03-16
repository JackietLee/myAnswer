package com.handsome.jay.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DetailStatus {

    IN(1),
    OUT(2);

    final int amount;

}
