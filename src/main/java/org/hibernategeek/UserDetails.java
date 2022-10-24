package org.hibernategeek;


import javax.persistence.*;

@Entity
@Table(name = "users_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "details")
    private User user;

    public UserDetails(String email, String city) {
        this.email = email;
        this.city = city;
    }

    public UserDetails() {

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString(){
        return String.format("User Details [id - %d, email - %s, city - %s]", id, email, city);
    }
}
