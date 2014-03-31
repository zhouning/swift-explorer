/*
 * Copyright 2014 Loic Merckel
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.swiftexplorer.config.swift;

import org.javaswift.joss.instructions.UploadInstructions;

public class SwiftParameters implements HasSwiftSettings {

	private final long segmentationSize ;
	
	public static final long MIN_SEGMENTATION_SIZE = 10485760 ; // 10MB
	public static final long MAX_SEGMENTATION_SIZE = UploadInstructions.MAX_SEGMENTATION_SIZE ;
	
	@Override
	public long getSegmentationSize() {
		return segmentationSize;
	}
	
	
	private SwiftParameters (Builder b)
	{
		super () ;
		this.segmentationSize = b.segmentationSize ;
	}
	
	
	public static class Builder
	{
		private final long segmentationSize ;
        
        public Builder (long segmentationSize)
        {
        	super () ;
        	this.segmentationSize = Math.max(MIN_SEGMENTATION_SIZE, Math.min(segmentationSize, MAX_SEGMENTATION_SIZE)) ;
        }
        
        public SwiftParameters build ()
        {
        	return new SwiftParameters (this) ;
        }
	}
}
