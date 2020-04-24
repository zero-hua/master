package ink.zerohua.springboot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class Employee implements Serializable {
    private String id;
    private String name;
    private String sex;
    private Date birthday;
    private String email;
    private String dept;
}
