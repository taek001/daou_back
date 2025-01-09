package recruit.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDisbursement is a Querydsl query type for Disbursement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDisbursement extends EntityPathBase<Disbursement> {

    private static final long serialVersionUID = 1916538556L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDisbursement disbursement = new QDisbursement("disbursement");

    public final QBudget budget;

    public final ListPath<DisbursementItem, QDisbursementItem> items = this.<DisbursementItem, QDisbursementItem>createList("items", DisbursementItem.class, QDisbursementItem.class, PathInits.DIRECT2);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final EnumPath<recruit.enumeration.DisbursementStatusEnum> status = createEnum("status", recruit.enumeration.DisbursementStatusEnum.class);

    public final StringPath title = createString("title");

    public QDisbursement(String variable) {
        this(Disbursement.class, forVariable(variable), INITS);
    }

    public QDisbursement(Path<? extends Disbursement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDisbursement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDisbursement(PathMetadata metadata, PathInits inits) {
        this(Disbursement.class, metadata, inits);
    }

    public QDisbursement(Class<? extends Disbursement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.budget = inits.isInitialized("budget") ? new QBudget(forProperty("budget"), inits.get("budget")) : null;
    }

}

