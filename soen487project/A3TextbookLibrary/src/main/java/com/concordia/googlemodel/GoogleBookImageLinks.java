package com.concordia.googlemodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoogleBookImageLinks {
    private String smallThumbnail;
    private String thumbnail;
}
