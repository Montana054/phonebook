package models;

import lombok.*;
@Setter
@Getter
@Builder
public class Contacts {
    String name;
    String lastName;
    String phone;
    String email;
    String address;
    String description;
}
