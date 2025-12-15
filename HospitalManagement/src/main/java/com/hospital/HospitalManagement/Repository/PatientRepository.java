package com.hospital.HospitalManagement.Repository;

import com.hospital.HospitalManagement.dto.BloodGroupStats;
import com.hospital.HospitalManagement.dto.PatientDTO;
import com.hospital.HospitalManagement.dto.PatientInfo;
import com.hospital.HospitalManagement.entity.PatientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,Long> {

    @Query("""
    SELECT 
        p.id AS id,
        p.name AS name,
        p.email AS email
    FROM PatientEntity p
""")
    List<PatientDTO> getAllPatients();

    @Query("""
    SELECT new com.hospital.HospitalManagement.dto.PatientInfo(
        p.id,
        p.name,
        p.email)
    FROM PatientEntity p
""")
    List<PatientInfo> getAllPatientsInfo();

    @Query("select new com.hospital.HospitalManagement.dto.BloodGroupStats(p.bloodGroup, " +
            "COUNT(p)) from PatientEntity p group by p.bloodGroup order by COUNT(p) DESC")
    List<BloodGroupStats> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("UPDATE PatientEntity p set p.name = :name where p.id = :id")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);
}
