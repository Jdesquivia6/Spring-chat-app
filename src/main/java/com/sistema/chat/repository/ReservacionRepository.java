///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sistema.chat.repository;
//
//import com.sistema.chat.models.Reservacion;
//import com.sistema.chat.models.Vehiculo;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.List;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
///**
// *
// * @author jdesquivia
// */
//@Repository
//public interface ReservacionRepository extends JpaRepository<Reservacion, Long> {
//
//    @Query("SELECT r FROM Reservacion r WHERE r.vehiculo = :vehiculo "
//            + "AND ((r.fecha_inicio BETWEEN :fechaInicio AND :fechaFin) OR "
//            + "(r.fecha_fin BETWEEN :fechaInicio AND :fechaFin))")
//    List<Reservacion> findByVehiculoAndFechas(@Param("vehiculo") Vehiculo vehiculo,
//            @Param("fechaInicio") Date fechaInicio,
//            @Param("fechaFin") Date fechaFin);
//}
