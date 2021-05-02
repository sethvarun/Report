/*******************************************************************************
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 ******************************************************************************/

package com.oracle.report.util;

import java.util.Map;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

import com.oracle.report.Records;
import com.oracle.report.exception.RecordException;
import com.oracle.report.model.ContractModel;
import com.oracle.report.model.GeoZoneModel;
import com.oracle.report.model.RecordModel;
import com.oracle.report.model.ReportModel;

/**
 * This is helper class and have util methods
 * 
 * @author vseth
 */
public class HelperUtl {

   static ReportModel reportModel;

   /**
    * Private constructor. To stop object being create.
    */
   private HelperUtl() {

   }

   /**
    * Add record and process the same.
    * 
    * @param records
    * @param record
    * @throws RecordException
    */
   public static void addRecordTolist( Records records, String record ) throws RecordException {

      try {
         RecordModel recordModel = getRecordModel( record );

         records.notifyRecordAddedListeners( recordModel );
      }
      catch( Exception e ) {
         throw new RecordException( e.getMessage() + " Record:[" + record + "]" );
      }

   }

   /**
    * Parse and validate the records.
    * 
    * @param record
    * @return
    * @throws NumberFormatException
    * @throws Exception
    */
   private static RecordModel getRecordModel( String record ) throws NumberFormatException, Exception {

      String[] recordSplitArray = record.split( "," );
      if( recordSplitArray.length != 6 ) {
         throw new RecordException( "Expected element count is 6 but record has:" + recordSplitArray.length );
      }

      return new RecordModel( isEmpty( recordSplitArray[0] ), isEmpty( recordSplitArray[1] ), isEmpty( recordSplitArray[2] ), isEmpty( recordSplitArray[3] ), isEmpty( recordSplitArray[4] ), Integer.parseInt( isEmpty( recordSplitArray[5] ).substring( 0, recordSplitArray[5].length() - 1 ) ) );

   }

   /**
    * Validate string if empty or not
    * 
    * @param str
    * @return
    * @throws Exception
    */
   private static String isEmpty( String str ) throws Exception {

      if( str.trim().length() == 0 )
         throw new RecordException( "Empty element has been passed for record" );
      else
         return str;

   }

   /**
    * Get reportModel
    * 
    * @return
    */
   public static ReportModel getReportModel() {

      if( reportModel == null ) {
         reportModel = new ReportModel();
      }
      return reportModel;
   }

   /**
    * Generate JSON report based on data provided
    * 
    * @return String
    */
   public static String getReport() {

      JsonObjectBuilder reportObject = Json.createObjectBuilder();

      JsonObjectBuilder customerIDforContractID = Json.createObjectBuilder();
      for( Map.Entry <String, ContractModel> entrySet : getReportModel().getContractIDMap().entrySet() ) {
         customerIDforContractID.add( entrySet.getKey(), entrySet.getValue().getCustomerIdList().size() );
      }
      JsonObjectBuilder countUniqueCustomerIDforzeoZone = Json.createObjectBuilder();
      countUniqueCustomerIDforzeoZone.add( "countUniqueCustomerIDforContractID", customerIDforContractID );

      JsonObjectBuilder customerIDforGeoZone = Json.createObjectBuilder();
      JsonObjectBuilder avgBuildDurationforGeoZone = Json.createObjectBuilder();
      JsonObjectBuilder customerIDListforGeoZone = Json.createObjectBuilder();
      for( Map.Entry <String, GeoZoneModel> entrySet : getReportModel().getGeoZoneMap().entrySet() ) {
         customerIDforGeoZone.add( entrySet.getKey(), entrySet.getValue().getCustomerIdList().size() );
         avgBuildDurationforGeoZone.add( entrySet.getKey(), entrySet.getValue().getAvgBuildDuraion() +"s");
         customerIDListforGeoZone.add( entrySet.getKey(), entrySet.getValue().getCustomerIdList().stream().collect( Collectors.joining( "," ) ) );
      }

      countUniqueCustomerIDforzeoZone.add( "countUniqueCustomerIDforGeoZone", customerIDforGeoZone );
      countUniqueCustomerIDforzeoZone.add( "AvgBuildTimeforGeoZone", avgBuildDurationforGeoZone );
      countUniqueCustomerIDforzeoZone.add( "uniqueCustomerIDListforGeoZone", customerIDListforGeoZone );
      reportObject.add( "Report", countUniqueCustomerIDforzeoZone.build() );

      return reportObject.build().toString();
   }

}
