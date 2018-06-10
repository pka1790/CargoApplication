package com.sample.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sample.app.dto.PackageDetails;
import com.sample.app.dto.Trip;
import com.sample.app.dto.TripPackage;
import com.sample.app.dto.TripUserName;
import com.sample.app.dto.UserData;

public class CargoDaoIimpl implements CargoDao{

	@Override
	public int insertUserData(String dbDriver, String connectionUrl, String userName, String password,
			String dbQuery, UserData userData) {

		PreparedStatement pstmt = null;
		int result=0;
		ResultSet rset = null;
		Connection conn = getConnection(dbDriver,connectionUrl,userName,password);
		try {
			//INSERT INTO USERS"+ "(USERNAME,FIRSTNAME,LASTNAME,PASSWORD,EMAIL_ID,MOBILE,BIRTHDATE,REGISTERAS) VALUES"+ "(?,?,?,?,?,?,?,?)";
			pstmt= conn.prepareStatement(dbQuery,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,userData.getUsername());
			pstmt.setString(2, userData.getFirstname());
			pstmt.setString(3, userData.getLastname());
			pstmt.setString(4, userData.getPassword());
			pstmt.setString(5, userData.getEmailid());
			pstmt.setString(6, userData.getMobile());
			pstmt.setString(7, userData.getBirthdate());
			pstmt.setString(8, userData.getRegisteras());
			result=	pstmt.executeUpdate();
			if(result!=0){
				rset=pstmt.getGeneratedKeys();
				if(rset.next()){
					System.out.println(rset.getInt(1));
					return rset.getInt(1);	

				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeAll(conn,pstmt);
		}

		return result;
	}

	private void closeAll(Connection conn, PreparedStatement pstmt) {
		try {

			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}


	}

	private Connection getConnection(String dbDriver, String connectionUrl, String userName, String password) {
		System.out.println("DB connection...");
		Connection connection=null;	
		try {
			Class.forName(dbDriver);
			connection=DriverManager.getConnection(connectionUrl, userName, password);
			if(!connection.equals(null)){
				System.out.println(" Connection Success.");
				return connection;		
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return connection;
	}

	public UserData getCreds(String dbDriver, String connUrl, String username, String pass, String getQuery,
			String username2) {

		PreparedStatement pstmt = null;
		UserData userdata=null;
		ResultSet rs=null;
		Connection conn = getConnection(dbDriver,connUrl,username,pass);

		//"SELECT username,firstname,lastname,password,email_id,mobile,birthdate,registeras from users"+ "WHERE USERNAME = ?";
		try {
			pstmt= conn.prepareStatement(getQuery);
			pstmt.setString(1, username2);
			rs= pstmt.executeQuery();
			if(!rs.equals(null)){
				while(rs.next()){
					System.out.println(rs.getString(1)+" "+rs.getString(2));
					userdata= new UserData();
					userdata.setUsername(rs.getString(1));
					userdata.setFirstname(rs.getString(2));
					userdata.setLastname(rs.getString(3));
					userdata.setPassword(rs.getString(4));
					userdata.setEmailid(rs.getString(5));
					userdata.setMobile(rs.getString(6));
					userdata.setBirthdate(rs.getString(7));
					userdata.setRegisteras(rs.getString(8));
					userdata.setUserId(rs.getInt(9));

				}
				System.out.println(">>>>>>> "+userdata);
				return userdata;
			}else
				return userdata;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				closeAll(conn, pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		return userdata;
	}

	public int insertTripDetails(String dbDriver, String connUrl, String username, String pass, String insTrip, Trip trip) {

		PreparedStatement pstmt = null;
		int result=0;
		ResultSet rset = null;
		Connection conn = getConnection(dbDriver,connUrl,username,pass);

		//INSERT INTO TRIPS"+ "(STARTPOINT,ENDPOINT,DISTANCE,GENERATORID,TRANSPORTDTTM,SPECIALINSTRUCTION,VEHICLEPREFERENCE) VALUES"+ "(?,?,?,?,?,?,?)";
		try {
			pstmt= conn.prepareStatement(insTrip,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, trip.getStartPoint());
			pstmt.setString(2, trip.getEndPoint());
			pstmt.setString(3, trip.getDistance());
			pstmt.setInt(4, trip.getGeneratorId());
			pstmt.setString(5, trip.getTransportDate());
			pstmt.setString(6, trip.getSpecialInstruction());
			pstmt.setString(7, trip.getVehiclePreference());
			result=pstmt.executeUpdate();

			if(result!=0){
				rset=pstmt.getGeneratedKeys();
				if(rset.next()){
					int id=rset.getInt(1);
					return id;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				closeAll(conn, pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	public int insertPackageDetails(String dbDriver, String connUrl, String username, String pass, String insPackage,
			PackageDetails packageDetails) {
		//INSERT INTO PACKAGES"+ "(TRIPID,PKHEIGHT,PKWIDTH,PKWEIGHT,PKLENGTH,QUANTITY,SHIPMENTTYPE) VALUES"+ "(?,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		int result=0;
		int packageId=0;
		ResultSet rset=null;
		Connection conn= getConnection(dbDriver, connUrl, username, pass);
		if(conn!=null){
			try {
				pstmt=conn.prepareStatement(insPackage, Statement.RETURN_GENERATED_KEYS);
				pstmt.setInt(1, packageDetails.getTripId());
				pstmt.setString(2, packageDetails.getHeight());
				pstmt.setString(3, packageDetails.getWidth());
				pstmt.setString(4, packageDetails.getWeight());
				pstmt.setString(5, packageDetails.getLength());
				pstmt.setString(6, packageDetails.getItemCount());
				pstmt.setString(7, packageDetails.getShipment());
				result=pstmt.executeUpdate();
				if(result!=0){
					rset=pstmt.getGeneratedKeys();
					if(rset.next()){
						packageId=rset.getInt(1);
						return packageId;
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					rset.close();
					closeAll(conn, pstmt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}

		}
		return 0;
	}

	public List<Trip> getGenHist(String dbDriver, String connUrl, String username, String pass, String getTripHistory, int userId) {
		//select tripid,startpoint,endpoint, distance, tripstatus,vehiclePreference,specialInstruction from tripdata where  generatorId = '+appSession.user.userid
		ResultSet resultSet= null;
		PreparedStatement pstmt=null;
		Connection connection= getConnection(dbDriver, connUrl, username, pass);
		List<Trip> tripList= new ArrayList<Trip>();
		if(connection!=null){
			try {
				pstmt=connection.prepareStatement(getTripHistory);
				pstmt.setInt(1, userId);
				resultSet=pstmt.executeQuery();
				if(!resultSet.equals(null)){
					System.out.println("resultset is not empty");
					while (resultSet.next()) {
						Trip tripData= new Trip();
						tripData.setTripId(resultSet.getInt(1));
						tripData.setStartPoint(resultSet.getString(2));
						tripData.setEndPoint(resultSet.getString(3));
						tripData.setDistance(resultSet.getString(4));
						tripData.setTripStatus(resultSet.getString(5));
						tripData.setVehiclePreference(resultSet.getString(6));
						tripData.setSpecialInstruction(resultSet.getString(7));
						tripList.add(tripData);						
					}
					if(!tripList.isEmpty()){
						return tripList;
					}

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					resultSet.close();
					closeAll(connection, pstmt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
		return null;
	}

	public List<Trip> getCarrierData(String dbDriver, String connUrl, String username, String pass, String carrierData) {
		//select tripid,startpoint,endpoint,distance,tripstatus from trips where tripstatus = 'WAITING;
		ResultSet resultSet= null;
		Statement stmt=null;
		Connection connection= getConnection(dbDriver, connUrl, username, pass);
		List<Trip> tripList= new ArrayList<Trip>();
		if(connection!=null){
			try {
				stmt=connection.createStatement();
				resultSet=stmt.executeQuery(carrierData);
				if(!resultSet.equals(null)){
					System.out.println("resultset is not empty");
					while (resultSet.next()) {
						Trip tripData= new Trip();
						tripData.setTripId(resultSet.getInt(1));
						tripData.setStartPoint(resultSet.getString(2));
						tripData.setEndPoint(resultSet.getString(3));
						tripData.setDistance(resultSet.getString(4));
						tripData.setTripStatus(resultSet.getString(5));
						tripList.add(tripData);						
					}
					if(!tripList.isEmpty()){
						return tripList;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					resultSet.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
		return null;
	}

	public List<TripPackage> getTripsInfo(String dbDriver, String connUrl, String username, String pass, String cariTripInfo,
			int tripId) {
		//select A.tripid,A.startpoint,A.endpoint,A.distance,A.tripstatus,B.pkHeight,B.pkWeight,B.pkLength,B.pkWidth,
		//B.packageid,B.quantity,B.shipmentType from tripdata A inner join packageDetails B on A.tripid=B.tripid where A.tripid ='+tripId		
		ResultSet resultSet= null;
		PreparedStatement pstmt=null;
		Connection connection= getConnection(dbDriver, connUrl, username, pass);
		List<TripPackage> tripPackageList= new ArrayList<TripPackage>();
		if(connection!=null){
			try {
				pstmt=connection.prepareStatement(cariTripInfo);
				pstmt.setInt(1, tripId);
				resultSet=pstmt.executeQuery();
				if(!resultSet.equals(null)){
					while(resultSet.next()){
						TripPackage tripPackage= new TripPackage();
						tripPackage.setTripId(resultSet.getInt(1));
						tripPackage.setStartPoint(resultSet.getString(2));
						tripPackage.setEndPoint(resultSet.getString(3));
						tripPackage.setDistance(resultSet.getString(4));
						tripPackage.setTripStatus(resultSet.getString(5));
						tripPackage.setHeight(resultSet.getString(6));
						tripPackage.setWeight(resultSet.getString(7));
						tripPackage.setLength(resultSet.getString(8));
						tripPackage.setWidth(resultSet.getString(9));
						tripPackage.setPackageId(resultSet.getInt(10));
						tripPackage.setItemCount(resultSet.getString(11));
						tripPackage.setShipment(resultSet.getString(12));
						tripPackageList.add(tripPackage);
					}
					if(!tripPackageList.equals(null)){
						return tripPackageList;
					}

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					resultSet.close();
					closeAll(connection, pstmt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	public boolean updateAcceptTrip(String dbDriver, String connUrl, String username, String pass, String updateTrip, int tripId, int userId) {
		//update trips set tripStatus = 'ACEEPTED', carrierId= ? where tripid =?'";
		PreparedStatement pstmt=null;
		int update=0;
		int packageId=0;
		Connection conn= getConnection(dbDriver, connUrl, username, pass);
		if(conn!=null){

			try {
				pstmt=conn.prepareStatement(updateTrip);
				pstmt.setInt(1, userId);
				pstmt.setInt(2, tripId);
				update=pstmt.executeUpdate();

				if(update!=0){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeAll(conn, pstmt);
			}				

		}
		return false;
	}

	public List<TripUserName> getAcceptedTrips(String dbDriver, String connUrl, String username, String pass,
			String acceptedTrips, int userId) {
		//select t.tripid,t.tripStatus,t.startpoint,t.endpoint,t.distance,t.vehiclePreference,u.username 
		//from trips t inner join users u on u.userid=t.generatorId "+ "where t.carrierid="+"?"
		ResultSet resultSet= null;
		PreparedStatement pstmt=null;
		Connection connection= getConnection(dbDriver, connUrl, username, pass);
		List<TripUserName> tripList= new ArrayList<TripUserName>();
		if(connection!=null){

			try {
				pstmt=connection.prepareStatement(acceptedTrips);
				pstmt.setInt(1, userId);
				resultSet=pstmt.executeQuery();
				if(!resultSet.equals(null)){
					System.out.println("resultset is not empty");
					while (resultSet.next()) {
						TripUserName tripData= new TripUserName();
						tripData.setTripId(resultSet.getInt(1));
						tripData.setTripStatus(resultSet.getString(2));
						tripData.setStartPoint(resultSet.getString(3));
						tripData.setEndPoint(resultSet.getString(4));
						tripData.setDistance(resultSet.getString(5));
						tripData.setVehiclePreference(resultSet.getString(6));
						tripData.setUsername(resultSet.getString(7));
						tripList.add(tripData);
					}
					if(!tripList.equals(null)){
						return tripList;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tripList;
	}
}
