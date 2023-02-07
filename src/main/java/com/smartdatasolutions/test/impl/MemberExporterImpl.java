package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MemberExporterImpl implements MemberExporter {

	@Override
	public void writeMember( Member member, Writer writer ) throws IOException {
		writer = new BufferedWriter(new FileWriter(member.getState()+"_outputFile.csv",true));

		System.out.println(member.getState());
		System.out.println(member.toCSVString());
		writer.append( member.toCSVString()+'\n' );
		writer.flush();


		writer.close();

	}

}