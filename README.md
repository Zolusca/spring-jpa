<center>

## Belajar ORM pada java dengan spring jpa

</center>

---

### Relationship 
Terdapat 2 jenis relasi yakni :
1. UniBidirectional : hanya di salah satu entity
2. Bidirectional : di kedua entity

#### anotasi relationship

---
Note :
- nilai cascade bisa digunakan pada opposite class dan owner class
(kedua class atau lebih), masing - masing class memiliki cascade itu boleh.
- jangan gunakan CascadeType.ALL lebih baik spesifik saja
- jangan gunakan `@Data` pada entity, dapat menyebabkan cylic pada `toString()`
---

1. `cascade = CascadeType.PERSIST` =  contohnya class user
menggunakan anotasi `@OneToOne` kepada class role, maka ketika
inisialisasi class user dan kita inputkan object role maka 
role akan otomatis diinsert juga (lihat pada kode class user dan role beserta testing).
2. `cascade = CascadeType.REFRESH` = data pada context java spring dan
database bisa jadi berbeda karena kompleksitas dari kode program, dengan
menggunakan cascade refresh apabila di refresh maka kita akan mendapatkan
nilai object yang sesuai pada saat itu dari database.
3. `cascade = CascadeType.DECATCH` = ini digunakan ketika perubahan pada
context object tidak ingin di insert ke database.
4. `cascade = CascadeType.DELETE` = ini akan mendelete juga child 
dari entities 
5. `cascade = CascadeType.MERGE` = 
6. `fetch = FetchType.LAZY` = ini digunakan ketika data
relationship berupa collection, seperti pada `@oneToMany` atau `@ManyToMany`
yang akan menggunakan collection, maka nilai defaultnya adalah lazy.
Artinya data object tersebut tidak secara langsung diambil.
7. `fetch = FetchType.EAGER` = berkebalikan dengan lazy, data object dari
eager akan langsung diambil.
8. `orphanRemoval = true` ini berarti pada entities owner dapat menghapus
child, berbeda dengan cascade remove apabila owner dihapus maka
child ikut terhapus, orphanRemoval dapat menghapus child saja tanpa parent
9. `mappedBy` ini memberi tahu jpa bahwa sudah di konfigurasi pada class opposite

#### One To One
1. `@OneToOne`
Gunakan `@JoinColumn` pada entity yang memiliki foreign key entity lain
```java
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;
```

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
- `@JoinColumn` : identifikasi bahwa field foreign key `@JoinColumn(name = "role_id")` artinya
pada class ini foreignkey ke entity sebelah menggunakan role_id pada table database
  - `referencedColumnName` = memberi tahu bahwa foreign key ini references ke mana 
  `@JoinColumn(name = "role_id",referencedColumnName = "id")` artinya class references
  pada opposite/class sebelah adalah id.
- 