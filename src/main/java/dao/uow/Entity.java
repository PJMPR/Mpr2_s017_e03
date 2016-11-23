package dao.uow;

public class Entity {

	
	private EntityState state;
	IUnitOfWorkRepository repo;
	
	public Entity(IUnitOfWorkRepository repo) {
		super();
		this.repo = repo;
	}
	Object entity;
	
	public <TEntity> void setEntity(TEntity entity){
		this.entity= entity;
	}
	
	public <TEntity> TEntity getEntity(){
		return (TEntity) this.entity;
	}

	public EntityState getState() {
		return state;
	}

	public void setState(EntityState state) {
		this.state = state;
	}
	
	
	
	
}

