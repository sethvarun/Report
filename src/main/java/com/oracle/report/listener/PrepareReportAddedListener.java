/*******************************************************************************
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 ******************************************************************************/

package com.oracle.report.listener;

import java.util.Map;

import com.oracle.report.interfaces.IRecordAddedListener;
import com.oracle.report.model.ContractModel;
import com.oracle.report.model.GeoZoneModel;
import com.oracle.report.model.RecordModel;
import com.oracle.report.util.HelperUtl;

/**
 * This is the implemented class.
 * 
 * @author vseth
 */
public class PrepareReportAddedListener implements IRecordAddedListener {

   /**
    * This method will will called once new record added.
    * 
    * @param recordModel
    */
   @Override
   public void onRecordAdded( RecordModel recordModel ) {

      reportForContractID( recordModel );
      reportAsPerGeoZone( recordModel );

   }

   /**
    * Read the object and collect the records based on contract ID
    * 
    * @param recordModel
    */
   private void reportForContractID( RecordModel recordModel ) {

      Map <String, ContractModel> contractModelMap = HelperUtl.getReportModel().getContractIDMap();

      ContractModel contractModel = null;

      if( contractModelMap.containsKey( recordModel.getContractId() ) ) {
         contractModel = ( ContractModel )contractModelMap.get( recordModel.getContractId() );

         if( contractModel.getCustomerIdList() != null && !contractModel.getCustomerIdList().contains( recordModel.getCustomerId() ) ) {
            contractModel.getCustomerIdList().add( recordModel.getCustomerId() );
         }
      }
      else {
         contractModel = new ContractModel();
         contractModel.getCustomerIdList().add( recordModel.getCustomerId() );
      }

      contractModelMap.put( recordModel.getContractId(), contractModel );

   }

   /**
    * Read the object and collect the records based on geoZone ID
    * @param recordModel
    */
   private void reportAsPerGeoZone( RecordModel recordModel ) {

      Map <String, GeoZoneModel> geoZoneModelMap = HelperUtl.getReportModel().getGeoZoneMap();
      GeoZoneModel geoZonemodel = null;

      if( geoZoneModelMap.containsKey( recordModel.getGeozone() ) ) {
         geoZonemodel = ( GeoZoneModel )geoZoneModelMap.get( recordModel.getGeozone() );

         if( geoZonemodel.getCustomerIdList() != null && !geoZonemodel.getCustomerIdList().contains( recordModel.getCustomerId() ) ) {
            geoZonemodel.getCustomerIdList().add( recordModel.getCustomerId() );
         }
      }
      else {
         geoZonemodel = new GeoZoneModel();
         geoZonemodel.getCustomerIdList().add( recordModel.getCustomerId() );
      }
      geoZonemodel.setTotalRecords( geoZonemodel.getTotalRecords() + 1 );
      geoZonemodel.setAvgBuildDuraion( ( geoZonemodel.getAvgBuildDuraion() + recordModel.getBuildduration() ) / geoZonemodel.getTotalRecords() );
      geoZoneModelMap.put( recordModel.getGeozone(), geoZonemodel );

   }

}
