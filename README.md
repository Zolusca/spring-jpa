<center>

## Belajar ORM pada java dengan spring jpa

</center>

---

### Relationship 
Terdapat 2 jenis relasi yakni :
1. UniBidirectional : hanya di salah satu entity
2. Bidirectional : di kedua entity

#### anotasi relationship
1. `cascade = CascadeType.PERSIST` =  contohnya class user
menggunakan anotasi `@OneToOne` kepada class role, maka ketika
inisialisasi class user dan kita inputkan object role maka 
role akan otomatis diinsert juga (lihat pada kode class user dan role beserta testing)


#### One To One
1. `@OneToOne`

### Repository
#### 1. membuat query method
untuk membuat query method yang digunakan adalah nama field,
bukan nama field pada table ex : 
```java
// mencari by roleType -> nama field di entity
Optional<Role> findByroleType(RoleType name);
```

### Anotasi

- `@Entity`: indentifikasi sebagai entity class, akan dibuatkan bean otomatis
- `@Table`: memberikan nama table spesifik ke class `@Table(name="nama_table")`
- `@Id`: identifikasi bahwa field tersebut berupa id
- `@GeneratedValue`: bagaimana nilai id dibuat
    - Strategy = `GenerationType.IDENTITY` digunakan untuk auto increment 
    - Strategy = `GenerationType.UUID` digunakan untuk uuid string
    - Strategy = `GenerationType.AUTO` hibernate akan otomatis mengisi sesuai database
    - Strategy = `GenerationType.SEQUENCE` beberapa database seperti postgre memilikinya
- `@Column`: memberikan identitas pada field, dari nama kolom dan aturan pada column didatabase seperti not null atau unique
- `@Enumerated` : digunakan untuk tipe data enum
  - `EnumType.STRING` = nilai enum akan dikonversi sebagai string
  - `EnumType.ORDINAL` = nilai enum akan dikonversi sebagai integer (x)
- `@Transactional`: identifikasi bahwa pada method akan menggunakan transaksional