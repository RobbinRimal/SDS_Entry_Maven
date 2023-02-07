package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberImporterImpl implements MemberImporter {
	private String id;
	private String address;
	private String city;
	private String firstName;
	private String lastName;
	private String state;
	private String zip;

	@Override
	public List< Member > importMembers( File inputFile ) throws Exception {
		List<Member> memberList=new ArrayList<>();


		/*
		 * Implement the missing logic
		 */

		try (BufferedReader br = new BufferedReader( new FileReader( inputFile ) )) {
			String line = br.readLine( );

			while ( line != null ) {
				Member member=new Member();
				line = br.readLine( );
				char[] x=line.toCharArray();

				id=String.copyValueOf(Arrays.copyOfRange(x,0,11)).trim();
				lastName=String.valueOf(Arrays.copyOfRange(x,12,36)).trim();
				firstName=String.valueOf(Arrays.copyOfRange(x,37,61)).trim();
				address=String.valueOf(Arrays.copyOfRange(x,62,91)).trim();
				city=String.valueOf(Arrays.copyOfRange(x,92,111)).trim();
				state=String.valueOf(Arrays.copyOfRange(x,112,115)).trim();
				zip=String.valueOf(Arrays.copyOfRange(x,116,120)).trim();


				member.setId(id);
				member.setFirstName(firstName);
				member.setLastName(lastName);
				member.setAddress(address);
				member.setCity(city);
				member.setState(state);
				member.setZip(zip);

				memberList.add(member);


			}
		} catch (NullPointerException e){
			return memberList;
		}

		return null;
	}


}