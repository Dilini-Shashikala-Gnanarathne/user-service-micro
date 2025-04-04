package com.example.demo.mapper;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-04T20:35:36+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminDTO toDto(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminDTO.AdminDTOBuilder adminDTO = AdminDTO.builder();

        adminDTO.firstName( admin.getFirstName() );
        adminDTO.lastName( admin.getLastName() );
        adminDTO.mobile( admin.getMobile() );
        adminDTO.username( admin.getUsername() );
        adminDTO.password( admin.getPassword() );

        return adminDTO.build();
    }

    @Override
    public Admin toAdmin(AdminDTO adminDTO) {
        if ( adminDTO == null ) {
            return null;
        }

        Admin.AdminBuilder admin = Admin.builder();

        admin.firstName( adminDTO.getFirstName() );
        admin.lastName( adminDTO.getLastName() );
        admin.mobile( adminDTO.getMobile() );
        admin.username( adminDTO.getUsername() );
        admin.password( adminDTO.getPassword() );

        return admin.build();
    }
}
