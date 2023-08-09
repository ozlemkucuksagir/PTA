package com.smartIct.PublicTransport.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class XController {

    public XController(){}
    public XController(String asdf) {
        this.asdf = asdf;
    }

    private String asdf;
}
