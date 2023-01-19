package user.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_table")
public class UserEntity {
    @Id // PK 컬럼
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 역할
    @Column(name = "user_id") // 컬럼명
    private Long id;

    @Column() // 기본 varchar(255)크기로 생성됨
    private String userName;
    @Column(length = 50, unique = true)
    private String userEmail;

    @Column(length = 20)
    private String userPassword;


}
