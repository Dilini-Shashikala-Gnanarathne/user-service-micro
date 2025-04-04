package com.example.demo.mapper;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminDTO toDto(Admin admin);
    Admin toAdmin(AdminDTO adminDTO);
}
