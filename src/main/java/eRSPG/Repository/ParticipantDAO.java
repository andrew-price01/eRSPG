package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Participant;
import eRSPG.model.Proposal;

public interface ParticipantDAO {

	List<Participant> findAllParicipant();

	List<Participant> findAllPariticipantByProposalId(int pid);

	Participant findParticipant(int pid);

	void addNewOrUpdateParticipant(Participant p);

	void deleteParticipant(Participant p);

	void deleteAllParticipantByProposalId(int pid);

}