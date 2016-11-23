package dao.uow;

import java.util.ArrayList;
import java.util.List;

public class UnitOfWork implements IUnitOfWork {

	private List<Entity> entities = new ArrayList<Entity>();
	
	public void markAsNew(Entity entity) {
		entity.setState(EntityState.New);
		entities.add(entity);
	}

	public void markAsDeleted(Entity entity) {
		entity.setState(EntityState.Deleted);
		entities.add(entity);
	}

	public void markAsChanged(Entity entity) {
		entity.setState(EntityState.Changed);
		entities.add(entity);
	}

}
