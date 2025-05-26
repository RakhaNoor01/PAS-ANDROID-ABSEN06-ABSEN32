package com.example.pas_absen06_absen32.model;

public class Member {
    private String name;
    private String email;
    private String phone;
    private String absen;
    private String photoUrl; // ubah dari int ke String

    public Member(String name, String email, String phone, String absen, String photoUrl) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.absen = absen;
        this.photoUrl = photoUrl;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAbsen() { return absen; }
    public String getPhotoUrl() { return photoUrl; }
}
