package com.server;

import com.dao.Mappers;
import com.dbaccess.DBAService;
import com.entity.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName DBAServiceImpl
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-06-17 15:38
 * @Version 1.0
 */
@Service
public class DBAServiceImpl implements DBAService {



    @Autowired
    private Mappers mappers;

    private Logger logger = Logger.getLogger(DBAServiceImpl.class);

    @Override
    public Response addDeviceBasicsInfo(DeviceData deviceData) {

        Response response = new Response();
        try {
            deviceData.setRegDate(new Date());
            mappers.addDeviceBasicsInfo(deviceData);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {

        }

        return response;
    }

    @Override
    public Response deleteDeviceBasicsInfo(DeviceData deviceData) {
        Response response = new Response();
        try {
            mappers.deleteDeviceBasicsInfo(deviceData);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {
        }
        return response;

    }

    @Override
    public Response updateDeviceBasicsInfo(DeviceData deviceData) {
        Response response = new Response();
        try {
            mappers.updateDeviceBasicsInfo(deviceData);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {
        }
        return response;
    }

    @Override
    public Response getDeviceBasicsInfo(DeviceData deviceData, Paging paging) {
        Response response = new Response();
        try {
            List<DeviceData> deviceBasicsInfo = mappers.getDeviceBasicsInfo(deviceData);
            response.setResult(deviceBasicsInfo);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {


        }

        return response;

    }



    @Override
    public Response updateDeviceRealTimeData(DeviceData deviceData) {
        Response response = new Response();
        try {
            mappers.updateDeviceRealTimeData(deviceData);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {
        }
        return response;
    }

    @Override
    public Response getDeviceRealTimeData(DeviceData deviceData, Paging paging) {

        Response response = new Response();
        try {
            List<DeviceData> RealTimeData = mappers.getDeviceRealTimeData(deviceData);
            response.setResult(RealTimeData);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {


        }

        return response;


    }

    @Override
    public Response getDeviceHistoryData(DeviceData deviceData, Paging paging) {
        Response response = new Response();
        try {
            List<DeviceData> historyData = mappers.getDeviceHistoryData(deviceData);
            response.setResult(historyData);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {


        }

        return response;
    }

    @Override
    public Response addSensor(SensorBind sensorBind) {
        Response response = new Response();
        try {
            mappers.addSensorBind(sensorBind);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());


        } finally {
        }
        return response;
    }

    @Override
    public Response deleteSensor(SensorBind sensorBind) {
        Response response = new Response();
        try {
            mappers.deleteSensorBind(sensorBind);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());


        } finally {
        }
        return response;
    }

    @Override
    public Response getSensor(SensorBind sensorBind, Paging paging) {
        Response response = new Response();
        try {
            List<SensorBind> sensorBinds = mappers.getSensorBind(sensorBind);
            response.setResult(sensorBinds);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());


        } finally {


        }

        return response;
    }


    @Override
    public Response updateSensor(SensorBind sensorBind) {
        Response response = new Response();
        try {
            mappers.updateSensorBind(sensorBind);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());


        } finally {
        }
        return response;
    }

    @Override
    public Response addCamera(CameraBind cameraBind) {
        Response response = new Response();
        try {
            mappers.addCameraBind(cameraBind);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());


        } finally {
        }
        return response;
    }

    @Override
    public Response deleteCamera(CameraBind cameraBind) {
        Response response = new Response();
        try {
            mappers.deleteCameraBind(cameraBind);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());


        } finally {
        }
        return response;
    }

    @Override
    public Response getCamera(CameraBind cameraBind, Paging paging) {
        Response response = new Response();
        try {
            List<CameraBind> cameraBinds = mappers.getCameraBind(cameraBind);
            response.setResult(cameraBinds);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());


        } finally {


        }

        return response;
    }

    @Override
    public Response updateCamera(CameraBind cameraBind) {
        Response response = new Response();
//        try {
//            mappers.updateCameraBind(cameraBind);
//        } catch (Exception e) {
//            response.setResult(null);
//            response.setStatusCode(500);
//            logger.error(e.toString());
//
//
//        } finally {
//        }
        return response;
    }

    @Override
    public Response getCityArea(CityArea cityArea, Paging paging) {
        return null;
    }

    @Override
    public Response getCity(City city) {
        Response response = new Response();
        try {
            List<City> cityList = mappers.getCity(city);
            response.setResult(cityList);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {


        }

        return response;
    }

    @Override
    public Response getArea(Area area) {
        Response response = new Response();
        try {
            List<Area> areaList = mappers.getArea(area);
            response.setResult(areaList);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {


        }

        return response;
    }

    @Override
    public Response addUser(User user) {
        Response response = new Response();
        try {
            mappers.addUser(user);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());


        } finally {
        }
        return response;

}

    @Override
    public Response deleteUser(User user) {
        return null;
    }

    @Override
    public Response updateUser(User user) {
        Response response = new Response();
        try {
            mappers.updateUser(user);
        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());


        } finally {
        }
        return response;
    }

    @Override
    public Response getUser(User user, Paging paging) {

        Response response = new Response();
        try {
          List<User> userList= mappers.getUser(user);

          response.setResult(userList);

        } catch (Exception e) {
            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {

        }

        return response;

    }

    @Override
    public Response deviceAuthorize(DeviceAuthen deviceAuthen) {
        Response response = new Response();
        try {

            if ("add".equals(deviceAuthen.getaType())) {
                mappers.addDeviceAuthorize(deviceAuthen);
            }

            if ("delete".equals(deviceAuthen.getaType())) {
                mappers.deleteDeviceAuthorize(deviceAuthen);
            }
        } catch (Exception e) {

            response.setResult(null);
            response.setStatusCode(500);
            logger.error(e.toString());
            logger.error(e.getMessage());

        } finally {
        }
        return null;
    }
}
