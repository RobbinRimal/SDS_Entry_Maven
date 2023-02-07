package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main extends MemberFileConverter  {

	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		return null;
	}

	@Override
	protected MemberImporter getMemberImporter( ) {

		return null;
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {
		// TODO

		return membersFromFile.stream().distinct().collect(Collectors.toList());
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		Map<String, List<Member>> membersSplitByState = new HashMap<>();
		for (Member member : validMembers) {
			String state = member.getState();
			List<Member> membersInState = membersSplitByState.getOrDefault(state, new ArrayList<>());
			membersInState.add(member);
			membersSplitByState.put(state, membersInState);
		}
		return membersSplitByState;
	}

	public static void main( String[] args ) {

		MemberImporter memberImporter=new MemberImporterImpl();
		MemberExporter memberExporter=new MemberExporterImpl();


		Main mainObj=new Main();
		try {
			List<Member> memberList = memberImporter.importMembers(new File("Members.txt"));
			List<Member> nonDuplicateMembers = mainObj.getNonDuplicateMembers(memberList);
			Map<String, List<Member>> stringListMap = mainObj.splitMembersByState(nonDuplicateMembers);

			for (String key : stringListMap.keySet()) {
				FileWriter writer=new FileWriter(key+"_outputFile.csv");
				for (Member m:stringListMap.get(key)) {
					memberExporter.writeMember(m, writer);
				}
			}


		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}