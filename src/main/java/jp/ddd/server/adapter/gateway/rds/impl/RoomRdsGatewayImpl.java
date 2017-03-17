package jp.ddd.server.adapter.gateway.rds.impl;

import jp.ddd.server.adapter.gateway.rds.custom.RoomRdsGatewayCtm;
import jp.ddd.server.adapter.gateway.rds.entity.RoomRds;
import jp.ddd.server.other.utils.DsLists;
import jp.ddd.server.other.utils.enums.Status;
import lombok.val;
import org.eclipse.collections.api.list.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * Created by noguchi_kohei 
 */
@Repository
public class RoomRdsGatewayImpl implements RoomRdsGatewayCtm {
    @Autowired
    private EntityManager em;

    @Override
    public ImmutableList<RoomRds> findByDtDesc(Integer userId) {
        val results = em.createNamedQuery("Room.findWithRoomUserByUidDtStatusDesc") //
          .setParameter("uid", userId) //
          .setParameter("status", Status.VALID) //
          .getResultList();
        return DsLists.toImt(results);
    }

    @Override
    public Optional<RoomRds> getOpt(Integer id) {
        val results = em //
          .createNamedQuery("Room.getOptWithRoomUserByRidStatus")//
          .setParameter("rid", id) //
          .setParameter("status", Status.VALID) //
          .getResultList();
        return DsLists.getFirstOpt(results);
    }

}
