package eRSPG.Repository;

import java.util.List;

import eRSPG.model.SourceType;

public interface SourceTypeDAO {

	List<SourceType> findAllSourceType();

	SourceType findSourceTypeById(int raid);

	SourceType findSourceTypeByDesc(String desc);

	void addNewOrUpdateSourceType(SourceType ra);

	void deleteSourceType(SourceType ra);

}