package com.carpco.petcity.util;

import com.carpco.petcity.adapter.persistence.entity.CompanyEntity;
import com.carpco.petcity.adapter.persistence.entity.UserEntity;
import com.carpco.petcity.adapter.persistence.entity.VaccineEntity;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalTime.MIDNIGHT;

public class DataTestModelUtils {

    public static final CompanyEntity COMPANY_ENTITY_1 = CompanyEntity.builder()
            .actualCustomId(BigInteger.valueOf(11))
            .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
            .document("123-456-789")
            .enabled(true)
            .id(BigInteger.valueOf(1))
            .initialCustomId(BigInteger.valueOf(10))
            .name("veterinary1")
            .paid(true)
            .photo("photo")
            .build();
    public static final CompanyEntity COMPANY_ENTITY_2 = CompanyEntity.builder()
            .actualCustomId(BigInteger.valueOf(1))
            .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
            .document("456-123-789")
            .enabled(true)
            .id(BigInteger.valueOf(2))
            .name("name")
            .paid(true)
            .build();
    public static final UserEntity USER_ENTITY_1 = UserEntity.builder()
            .company(COMPANY_ENTITY_1)
            .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
            .document("123456789")
            .email("test@test.test")
            .enabled(true)
            .id(BigInteger.valueOf(1))
            .lastName("lastName")
            .name("name")
            .password("password")
            .phone("987654321")
            .build();
    public static final UserEntity USER_ENTITY_2 = UserEntity.builder()
            .company(COMPANY_ENTITY_2)
            .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
            .document("987654321")
            .email("create@test.test")
            .enabled(true)
            .id(BigInteger.valueOf(2))
            .lastName("test")
            .name("create")
            .password("password")
            .phone("600000000")
            .build();
    public static final VaccineEntity VACCINE_ENTITY_1 = VaccineEntity.builder()
            .id(BigInteger.valueOf(1))
            .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
            .enabled(true)
            .name("vaccine1")
            .company(COMPANY_ENTITY_1)
            .build();
    public static final VaccineEntity VACCINE_ENTITY_2 = VaccineEntity.builder()
            .id(BigInteger.valueOf(2))
            .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
            .enabled(true)
            .name("vaccine2")
            .company(COMPANY_ENTITY_1)
            .build();
    public static final VaccineEntity VACCINE_ENTITY_3 = VaccineEntity.builder()
            .id(BigInteger.valueOf(3))
            .creation(LocalDateTime.of(LocalDate.now(), MIDNIGHT))
            .enabled(true)
            .name("vaccine3")
            .company(COMPANY_ENTITY_2)
            .build();

    private DataTestModelUtils() {
        super();
    }
}
