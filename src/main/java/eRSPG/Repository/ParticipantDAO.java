package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Participant;

public interface ParticipantDAO {

	List<Participant> findAllParicipant();

	List<Participant> findAllPariticipantByProposalId(int pid);

	Participant findParticipant(int pid);

	int addNewParticipant(Participant p);

	boolean updateParticipant(Participant p);

	boolean deleteParticipant(Participant p);

	boolean deleteAllParticipantByProposalId(int pid);

}