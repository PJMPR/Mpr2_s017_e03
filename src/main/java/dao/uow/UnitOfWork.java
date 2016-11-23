package dao.uow;

public class UnitOfWork implements IUnitOfWork {

	public void markAsNew(Entity entity) {
		entity.setState(EntityState.New);
	}

	public void markAsDeleted(Entity entity) {
		entity.setState(EntityState.Deleted);
	}

	public void markAsChanged(Entity entity) {
		entity.setState(EntityState.Changed);
	}

}
