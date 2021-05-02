/*******************************************************************************
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
 ******************************************************************************/

package com.oracle.report.interfaces;

import com.oracle.report.model.RecordModel;

/**
 * 
 * @author vseth
 *
 */
public interface IRecordAddedListener {

   /**
    * 
    * @param recordModel
    */
   public void onRecordAdded( RecordModel recordModel );

}
