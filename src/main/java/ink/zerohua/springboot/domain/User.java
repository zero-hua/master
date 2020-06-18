package ink.zerohua.springboot.domain;

import lombok.Data;
/*
1、transien
    然而在实际开发过程中，我们常常会遇到这样的问题，这个类的有些属性需要序列化，而其他属性不需要被序列化，
    打个比方，如果一个用户有一些敏感信息如密码，银行卡号等），为了安全起见，不希望在网络操作（主要涉及到序列化操作，
    本地序列化缓存也适用）中被传输这些信息对应的变量就可以加上transient关键字。换句话说，这个字段的生命周期仅存于
    调用者的内存中而不会写到磁盘里持久化。


2、盐
    虽然每次 123 md5 之后都是202CB962AC59075B964B07152D234B70，但是 我加上盐，即 123+随机数，那么md5值不就不一样了吗？
    这个随机数，就是盐，而这个随机数也会在数据库里保存下来，每个不同的用户，随机数也是不一样的。再就是加密次数，加密一次是
    202CB962AC59075B964B07152D234B70，我可以加密两次呀，就是另一个数了。而黑客即便是拿到了加密后的密码，如果不知道到底
    加密了多少次，也是很难办的。
*/

@Data
public class User {
    private Integer id;
    private String username;
    private transient String password;
    private String salt;
}
