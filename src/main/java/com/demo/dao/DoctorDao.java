package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.entity.Doctor;
import com.demo.entity.Specialist;
import com.demo.entity.User;

public class DoctorDao {

	private Connection conn;

	public DoctorDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean registerDoctor(Doctor doctor) {
		boolean f = false;
		
		try {
			String sql = "insert into doctor(fullname,dob,qualification,specialist,email,mobno,password)"
					+ " values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, doctor.getFullname());
			ps.setString(2, doctor.getDob());
			ps.setString(3, doctor.getQualification());
			ps.setString(4, doctor.getSpecialist());
			ps.setString(5, doctor.getEmail());
			ps.setString(6, doctor.getMobno());
			ps.setString(7, doctor.getPassword());
			
			int i= ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		try {
			String sql = "select * from doctor order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobno(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public Doctor getDoctorById(int id) {
		
		Doctor d = null;
		try {
			String sql = "select * from doctor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobno(rs.getString(7));
				d.setPassword(rs.getString(8));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return d;
	}
	
	public boolean updateDoctor(Doctor doctor) {
		boolean f = false;
		
		try {
			String sql = "update doctor set fullname=?,dob=?,qualification=?,specialist=?,email=?,mobno=?,password=? "
					+ "where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, doctor.getFullname());
			ps.setString(2, doctor.getDob());
			ps.setString(3, doctor.getQualification());
			ps.setString(4, doctor.getSpecialist());
			ps.setString(5, doctor.getEmail());
			ps.setString(6, doctor.getMobno());
			ps.setString(7, doctor.getPassword());
			ps.setInt(8, doctor.getId());
			int i= ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteDoctor(int id) {
		boolean f = false;
		
		try {
			
			String sql = "delete from doctor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i= ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
public Doctor login(String email,String password) {
		
		Doctor d = null;
		
		try {
			String sql = "select * from doctor where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobno(rs.getString(7));
				d.setPassword(rs.getString(8));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	public int countDoctor() {
		int i=0;
		
		try {
			String sql = "select * from doctor";
			PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs= ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return i;
	}

	public int countAppointment() {
		int i=0;
		
		try {
			String sql = "select * from appointment";
			PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs= ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int countUser() {
		int i=0;
		
		try {
			String sql = "select * from user_dtls";
			PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs= ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int countSpecialist() {
		int i=0;
		
		try {
			String sql = "select * from specialist";
			PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs= ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int countAppointmentByDoctorId(int did) {
		int i=0;
		
		try {
			String sql = "select * from appointment where doctorId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			 ResultSet rs= ps.executeQuery();
			 while(rs.next()) {
				 i++;
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return i;
	}
	
	public boolean checkOldPassword(int doctorid,String oldPassword) {
		boolean f = false;
		
		try {
			String sql = "select * from doctor where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, doctorid);
			ps.setString(2, oldPassword);
			
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				f=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean changePassword(int doctorid,String newPassword) {
		boolean f = false;
		
		try {
			String sql = "update doctor set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, newPassword);
			ps.setInt(2, doctorid);
			
			int i= ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean editProfileDoctor(Doctor doctor) {
		boolean f = false;
		
		try {
			String sql = "update doctor set fullname=?,dob=?,qualification=?,specialist=?,email=?,mobno=? "
					+ "where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, doctor.getFullname());
			ps.setString(2, doctor.getDob());
			ps.setString(3, doctor.getQualification());
			ps.setString(4, doctor.getSpecialist());
			ps.setString(5, doctor.getEmail());
			ps.setString(6, doctor.getMobno());
			ps.setInt(7, doctor.getId());
			int i= ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}
}
