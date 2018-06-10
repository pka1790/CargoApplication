package com.sample.app.service;

import java.util.List;

import com.sample.app.dto.PackageDetails;
import com.sample.app.dto.Trip;
import com.sample.app.dto.TripPackage;
import com.sample.app.dto.TripUserName;
import com.sample.app.dto.UserData;
import com.sample.dao.CargoDaoIimpl;

public class CargoService {

	private static final String DB_DRIVER="com.mysql.jdbc.Driver";
	private static final String CONN_URL="jdbc:mysql://localhost:3306/cargo_buisness";
	private static final String USERNAME="root";
	private static final String PASS="root";	
	private static final String INS_QUERY="INSERT INTO USERS"+ "(USERNAME,FIRSTNAME,LASTNAME,PASSWORD,EMAIL_ID,MOBILE,BIRTHDATE,REGISTERAS) VALUES"+ "(?,?,?,?,?,?,?,?)";
	private static final String GET_CREDS="SELECT username,firstname,lastname,password,email_id,mobile,birthdate,registeras,userid from users where username = "+"?";
	private static final String INS_TRIP="INSERT INTO TRIPS"+ "(STARTPOINT,ENDPOINT,DISTANCE,GENERATORID,TRANSPORTDTTM,SPECIALINSTRUCTION,VEHICLEPREFERENCE) VALUES"+ "(?,?,?,?,?,?,?)";
	private static final String INS_PACKAGE="INSERT INTO PACKAGES"+ "(TRIPID,PKHEIGHT,PKWIDTH,PKWEIGHT,PKLENGTH,QUANTITY,SHIPMENTTYPE) VALUES"+ "(?,?,?,?,?,?,?)";
	private static final String GET_TRIP_HISTORY="select tripid,startpoint,endpoint, distance, tripStatus,vehiclePreference,specialInstruction from trips where generatorId ="+"?";
	private static final String CARRIER_DATA="select tripid,startpoint,endpoint,distance,tripstatus from trips where tripstatus = 'WAITING'";
	private static final String CARI_TRIP_INFO="select A.tripid,A.startpoint,A.endpoint,A.distance,A.tripstatus,B.pkHeight,B.pkWeight,B.pkLength,B.pkWidth,B.packageid,B.quantity,B."
			+ "shipmentType from trips A inner join packages B on A.tripid=B.tripid where A.tripid ="+"?";
	private static final String UPDATE_TRIP="update trips set tripStatus = 'ACEEPTED'"+", carrierId= "+"?"+" where tripid ="+"?";
	private static final String ACCEPTED_TRIPS="select t.tripid,t.tripStatus,t.startpoint,t.endpoint,t.distance,t.vehiclePreference,u.username from trips t inner join users u on u.userid=t.generatorId "
			+ "where t.carrierid="+"?";
	public boolean registerUser(UserData userData) {
		CargoDaoIimpl daoIimpl= new CargoDaoIimpl();
		if(userData!=null){
			int id=daoIimpl.insertUserData(DB_DRIVER, CONN_URL, USERNAME, PASS, INS_QUERY,userData);

			if(id!=0){
				userData.setUserId(id);
				return true;
			}
		}
		return false;
	}

	public UserData logIn(String username2) {
		CargoDaoIimpl daoImpl= new CargoDaoIimpl();
		if(username2!=null){
			UserData data= daoImpl.getCreds(DB_DRIVER, CONN_URL, USERNAME, PASS, GET_CREDS,username2);
			return data;
		}
		return null;	
	}

	public int addTripDetails(Trip trip) {
		CargoDaoIimpl daoIimpl= new CargoDaoIimpl();
		if(trip!=null){

			int id=daoIimpl.insertTripDetails(DB_DRIVER,CONN_URL,USERNAME,PASS,INS_TRIP,trip);
			if(id!=0){
				return id;
			}
		}

		return 0;
	}

	public int addPackageDetails(PackageDetails packageDetails) {
		CargoDaoIimpl cargoDaoIimpl= new CargoDaoIimpl();
		int pacakge_id=cargoDaoIimpl.insertPackageDetails(DB_DRIVER,CONN_URL,USERNAME,PASS,INS_PACKAGE,packageDetails);
		if(pacakge_id!=0){
			return pacakge_id;
		}
		return 0;

	}

	public List<Trip> getGenHistory(int userId) {
		// TODO Auto-generated method stub
		CargoDaoIimpl cargoDaoIimpl= new CargoDaoIimpl();
		return cargoDaoIimpl.getGenHist(DB_DRIVER,CONN_URL,USERNAME,PASS,GET_TRIP_HISTORY,userId);

	}

	public List<Trip> getCarrierData() {

		CargoDaoIimpl cargoDaoIimpl= new CargoDaoIimpl();
		return cargoDaoIimpl.getCarrierData(DB_DRIVER,CONN_URL,USERNAME,PASS,CARRIER_DATA);

	}

	public List<TripPackage> getTripInfo(int tripId) {
		// TODO Auto-generated method stub
		CargoDaoIimpl cargoDaoIimpl= new CargoDaoIimpl();
		return cargoDaoIimpl.getTripsInfo(DB_DRIVER,CONN_URL,USERNAME,PASS,CARI_TRIP_INFO,tripId);

	}

	public boolean updateTrip(int tripId, int userId) {
		CargoDaoIimpl daoIimpl= new CargoDaoIimpl();
		return daoIimpl.updateAcceptTrip(DB_DRIVER,CONN_URL,USERNAME,PASS,UPDATE_TRIP,tripId,userId);
	}

	public List<TripUserName> getAcceptedCarrierData(int userId) {
		CargoDaoIimpl cargoDaoIimpl= new CargoDaoIimpl();

		return cargoDaoIimpl.getAcceptedTrips(DB_DRIVER,CONN_URL,USERNAME,PASS,ACCEPTED_TRIPS,userId);
	}






}
