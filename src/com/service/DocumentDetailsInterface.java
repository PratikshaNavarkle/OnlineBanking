package com.service;

import java.util.List;

import com.model.DocumentDetails;
import com.model.PersonalDetails;

public interface DocumentDetailsInterface 
{
	//insert
	public int addDocument(DocumentDetails d);

	//display
	public List<DocumentDetails> getAllDocumentDetails();

	//delete record
	public int deleteDocument(long accNo);

	//search
	public DocumentDetails searchDocument(long accNo);

	//update 
	public DocumentDetails updateDocument(DocumentDetails d);
}
