package recruit.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDisbursementItem is a Querydsl query type for DisbursementItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDisbursementItem extends EntityPathBase<DisbursementItem> {

    private static final long serialVersionUID = -1006551057L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDisbursementItem disbursementItem = new QDisbursementItem("disbursementItem");

    public final EnumPath<recruit.enumeration.CurrencyTypeEnum> currencyType = createEnum("currencyType", recruit.enumeration.CurrencyTypeEnum.class);

    public final QDisbursement disbursement;

    public final NumberPath<Double> exchangeRate = createNumber("exchangeRate", Double.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final NumberPath<Double> unitPrice = createNumber("unitPrice", Double.class);

    public QDisbursementItem(String variable) {
        this(DisbursementItem.class, forVariable(variable), INITS);
    }

    public QDisbursementItem(Path<? extends DisbursementItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDisbursementItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDisbursementItem(PathMetadata metadata, PathInits inits) {
        this(DisbursementItem.class, metadata, inits);
    }

    public QDisbursementItem(Class<? extends DisbursementItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.disbursement = inits.isInitialized("disbursement") ? new QDisbursement(forProperty("disbursement"), inits.get("disbursement")) : null;
    }

}

