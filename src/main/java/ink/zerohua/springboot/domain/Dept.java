package ink.zerohua.springboot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Dept {
    private Integer dId;
    private String dName;
    private Integer dCount;
}
