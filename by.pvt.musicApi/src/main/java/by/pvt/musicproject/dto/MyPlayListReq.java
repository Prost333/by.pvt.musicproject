package by.pvt.musicproject.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MyPlayListReq {
    private  Long id;
    private  Long userId;



}
