package com.compilesense.liuyi.welcomerobottechstyle.javabean;

import java.util.List;

/**
 * Created by shenjingyuan002 on 2016/12/2.
 */

public class WeatherBean{

    /**
     * status : ok
     * lang : zh_CN
     * result : {"hourly":{"status":"ok","description":"未来24小时晴","skycon":[{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 11:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 12:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 13:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 14:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 15:00"},{"value":"CLEAR_DAY","datetime":"2016-12-05 16:00"},{"value":"CLEAR_DAY","datetime":"2016-12-05 17:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 18:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 19:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 20:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 21:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 22:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 23:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 00:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 01:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 02:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 03:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 04:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2016-12-06 05:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2016-12-06 06:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-06 07:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-06 08:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-06 09:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 10:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 11:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 12:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 13:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 14:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 15:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 16:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 17:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 18:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 19:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 20:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 21:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 22:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 23:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 00:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 01:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 02:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 03:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 04:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 05:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 06:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 07:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 08:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 09:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 10:00"}],"cloudrate":[{"value":0.67,"datetime":"2016-12-05 11:00"},{"value":0.61,"datetime":"2016-12-05 12:00"},{"value":0.5,"datetime":"2016-12-05 13:00"},{"value":0.36,"datetime":"2016-12-05 14:00"},{"value":0.21,"datetime":"2016-12-05 15:00"},{"value":0.08,"datetime":"2016-12-05 16:00"},{"value":0,"datetime":"2016-12-05 17:00"},{"value":0,"datetime":"2016-12-05 18:00"},{"value":0,"datetime":"2016-12-05 19:00"},{"value":0,"datetime":"2016-12-05 20:00"},{"value":0.01,"datetime":"2016-12-05 21:00"},{"value":0.01,"datetime":"2016-12-05 22:00"},{"value":0,"datetime":"2016-12-05 23:00"},{"value":0,"datetime":"2016-12-06 00:00"},{"value":0,"datetime":"2016-12-06 01:00"},{"value":0.03,"datetime":"2016-12-06 02:00"},{"value":0.1,"datetime":"2016-12-06 03:00"},{"value":0.19,"datetime":"2016-12-06 04:00"},{"value":0.29,"datetime":"2016-12-06 05:00"},{"value":0.38,"datetime":"2016-12-06 06:00"},{"value":0.43,"datetime":"2016-12-06 07:00"},{"value":0.4,"datetime":"2016-12-06 08:00"},{"value":0.29,"datetime":"2016-12-06 09:00"},{"value":0.13,"datetime":"2016-12-06 10:00"},{"value":0,"datetime":"2016-12-06 11:00"},{"value":0,"datetime":"2016-12-06 12:00"},{"value":0,"datetime":"2016-12-06 13:00"},{"value":0,"datetime":"2016-12-06 14:00"},{"value":0.01,"datetime":"2016-12-06 15:00"},{"value":0.01,"datetime":"2016-12-06 16:00"},{"value":0,"datetime":"2016-12-06 17:00"},{"value":0,"datetime":"2016-12-06 18:00"},{"value":0,"datetime":"2016-12-06 19:00"},{"value":0,"datetime":"2016-12-06 20:00"},{"value":0,"datetime":"2016-12-06 21:00"},{"value":0,"datetime":"2016-12-06 22:00"},{"value":0,"datetime":"2016-12-06 23:00"},{"value":0,"datetime":"2016-12-07 00:00"},{"value":0,"datetime":"2016-12-07 01:00"},{"value":0,"datetime":"2016-12-07 02:00"},{"value":0,"datetime":"2016-12-07 03:00"},{"value":0,"datetime":"2016-12-07 04:00"},{"value":0,"datetime":"2016-12-07 05:00"},{"value":0,"datetime":"2016-12-07 06:00"},{"value":0,"datetime":"2016-12-07 07:00"},{"value":0,"datetime":"2016-12-07 08:00"},{"value":0,"datetime":"2016-12-07 09:00"},{"value":0,"datetime":"2016-12-07 10:00"}],"aqi":[{"value":179,"datetime":"2016-12-05 11:00"},{"value":165,"datetime":"2016-12-05 12:00"},{"value":155,"datetime":"2016-12-05 13:00"},{"value":150,"datetime":"2016-12-05 14:00"},{"value":148,"datetime":"2016-12-05 15:00"},{"value":146,"datetime":"2016-12-05 16:00"},{"value":145,"datetime":"2016-12-05 17:00"},{"value":144,"datetime":"2016-12-05 18:00"},{"value":143,"datetime":"2016-12-05 19:00"},{"value":141,"datetime":"2016-12-05 20:00"},{"value":140,"datetime":"2016-12-05 21:00"},{"value":139,"datetime":"2016-12-05 22:00"},{"value":138,"datetime":"2016-12-05 23:00"},{"value":136,"datetime":"2016-12-06 00:00"},{"value":136,"datetime":"2016-12-06 01:00"},{"value":135,"datetime":"2016-12-06 02:00"},{"value":134,"datetime":"2016-12-06 03:00"},{"value":134,"datetime":"2016-12-06 04:00"},{"value":133,"datetime":"2016-12-06 05:00"},{"value":132,"datetime":"2016-12-06 06:00"},{"value":132,"datetime":"2016-12-06 07:00"},{"value":130,"datetime":"2016-12-06 08:00"},{"value":130,"datetime":"2016-12-06 09:00"},{"value":130,"datetime":"2016-12-06 10:00"},{"value":129,"datetime":"2016-12-06 11:00"},{"value":129,"datetime":"2016-12-06 12:00"},{"value":128,"datetime":"2016-12-06 13:00"},{"value":127,"datetime":"2016-12-06 14:00"},{"value":127,"datetime":"2016-12-06 15:00"},{"value":125,"datetime":"2016-12-06 16:00"},{"value":125,"datetime":"2016-12-06 17:00"},{"value":125,"datetime":"2016-12-06 18:00"},{"value":124,"datetime":"2016-12-06 19:00"},{"value":123,"datetime":"2016-12-06 20:00"},{"value":123,"datetime":"2016-12-06 21:00"},{"value":122,"datetime":"2016-12-06 22:00"},{"value":122,"datetime":"2016-12-06 23:00"},{"value":122,"datetime":"2016-12-07 00:00"},{"value":122,"datetime":"2016-12-07 01:00"},{"value":121,"datetime":"2016-12-07 02:00"},{"value":121,"datetime":"2016-12-07 03:00"},{"value":121,"datetime":"2016-12-07 04:00"},{"value":119,"datetime":"2016-12-07 05:00"},{"value":119,"datetime":"2016-12-07 06:00"},{"value":118,"datetime":"2016-12-07 07:00"},{"value":118,"datetime":"2016-12-07 08:00"},{"value":118,"datetime":"2016-12-07 09:00"},{"value":118,"datetime":"2016-12-07 10:00"}],"humidity":[{"value":0.72,"datetime":"2016-12-05 11:00"},{"value":0.62,"datetime":"2016-12-05 12:00"},{"value":0.52,"datetime":"2016-12-05 13:00"},{"value":0.44,"datetime":"2016-12-05 14:00"},{"value":0.37,"datetime":"2016-12-05 15:00"},{"value":0.33,"datetime":"2016-12-05 16:00"},{"value":0.34,"datetime":"2016-12-05 17:00"},{"value":0.42,"datetime":"2016-12-05 18:00"},{"value":0.52,"datetime":"2016-12-05 19:00"},{"value":0.57,"datetime":"2016-12-05 20:00"},{"value":0.56,"datetime":"2016-12-05 21:00"},{"value":0.49,"datetime":"2016-12-05 22:00"},{"value":0.41,"datetime":"2016-12-05 23:00"},{"value":0.36,"datetime":"2016-12-06 00:00"},{"value":0.34,"datetime":"2016-12-06 01:00"},{"value":0.32,"datetime":"2016-12-06 02:00"},{"value":0.31,"datetime":"2016-12-06 03:00"},{"value":0.31,"datetime":"2016-12-06 04:00"},{"value":0.32,"datetime":"2016-12-06 05:00"},{"value":0.35,"datetime":"2016-12-06 06:00"},{"value":0.38,"datetime":"2016-12-06 07:00"},{"value":0.38,"datetime":"2016-12-06 08:00"},{"value":0.35,"datetime":"2016-12-06 09:00"},{"value":0.3,"datetime":"2016-12-06 10:00"},{"value":0.26,"datetime":"2016-12-06 11:00"},{"value":0.25,"datetime":"2016-12-06 12:00"},{"value":0.25,"datetime":"2016-12-06 13:00"},{"value":0.26,"datetime":"2016-12-06 14:00"},{"value":0.26,"datetime":"2016-12-06 15:00"},{"value":0.27,"datetime":"2016-12-06 16:00"},{"value":0.28,"datetime":"2016-12-06 17:00"},{"value":0.32,"datetime":"2016-12-06 18:00"},{"value":0.36,"datetime":"2016-12-06 19:00"},{"value":0.4,"datetime":"2016-12-06 20:00"},{"value":0.43,"datetime":"2016-12-06 21:00"},{"value":0.46,"datetime":"2016-12-06 22:00"},{"value":0.48,"datetime":"2016-12-06 23:00"},{"value":0.5,"datetime":"2016-12-07 00:00"},{"value":0.52,"datetime":"2016-12-07 01:00"},{"value":0.53,"datetime":"2016-12-07 02:00"},{"value":0.54,"datetime":"2016-12-07 03:00"},{"value":0.55,"datetime":"2016-12-07 04:00"},{"value":0.56,"datetime":"2016-12-07 05:00"},{"value":0.58,"datetime":"2016-12-07 06:00"},{"value":0.6,"datetime":"2016-12-07 07:00"},{"value":0.58,"datetime":"2016-12-07 08:00"},{"value":0.54,"datetime":"2016-12-07 09:00"},{"value":0.47,"datetime":"2016-12-07 10:00"}],"pm25":[{"value":135,"datetime":"2016-12-05 11:00"},{"value":125,"datetime":"2016-12-05 12:00"},{"value":118,"datetime":"2016-12-05 13:00"},{"value":115,"datetime":"2016-12-05 14:00"},{"value":113,"datetime":"2016-12-05 15:00"},{"value":112,"datetime":"2016-12-05 16:00"},{"value":111,"datetime":"2016-12-05 17:00"},{"value":110,"datetime":"2016-12-05 18:00"},{"value":109,"datetime":"2016-12-05 19:00"},{"value":108,"datetime":"2016-12-05 20:00"},{"value":107,"datetime":"2016-12-05 21:00"},{"value":106,"datetime":"2016-12-05 22:00"},{"value":105,"datetime":"2016-12-05 23:00"},{"value":104,"datetime":"2016-12-06 00:00"},{"value":104,"datetime":"2016-12-06 01:00"},{"value":103,"datetime":"2016-12-06 02:00"},{"value":102,"datetime":"2016-12-06 03:00"},{"value":102,"datetime":"2016-12-06 04:00"},{"value":101,"datetime":"2016-12-06 05:00"},{"value":100,"datetime":"2016-12-06 06:00"},{"value":100,"datetime":"2016-12-06 07:00"},{"value":99,"datetime":"2016-12-06 08:00"},{"value":99,"datetime":"2016-12-06 09:00"},{"value":99,"datetime":"2016-12-06 10:00"},{"value":98,"datetime":"2016-12-06 11:00"},{"value":98,"datetime":"2016-12-06 12:00"},{"value":97,"datetime":"2016-12-06 13:00"},{"value":96,"datetime":"2016-12-06 14:00"},{"value":96,"datetime":"2016-12-06 15:00"},{"value":95,"datetime":"2016-12-06 16:00"},{"value":95,"datetime":"2016-12-06 17:00"},{"value":95,"datetime":"2016-12-06 18:00"},{"value":94,"datetime":"2016-12-06 19:00"},{"value":93,"datetime":"2016-12-06 20:00"},{"value":93,"datetime":"2016-12-06 21:00"},{"value":92,"datetime":"2016-12-06 22:00"},{"value":92,"datetime":"2016-12-06 23:00"},{"value":92,"datetime":"2016-12-07 00:00"},{"value":92,"datetime":"2016-12-07 01:00"},{"value":91,"datetime":"2016-12-07 02:00"},{"value":91,"datetime":"2016-12-07 03:00"},{"value":91,"datetime":"2016-12-07 04:00"},{"value":90,"datetime":"2016-12-07 05:00"},{"value":90,"datetime":"2016-12-07 06:00"},{"value":89,"datetime":"2016-12-07 07:00"},{"value":89,"datetime":"2016-12-07 08:00"},{"value":89,"datetime":"2016-12-07 09:00"},{"value":89,"datetime":"2016-12-07 10:00"}],"precipitation":[{"value":0,"datetime":"2016-12-05 11:00"},{"value":0,"datetime":"2016-12-05 12:00"},{"value":0,"datetime":"2016-12-05 13:00"},{"value":0,"datetime":"2016-12-05 14:00"},{"value":0,"datetime":"2016-12-05 15:00"},{"value":0,"datetime":"2016-12-05 16:00"},{"value":0,"datetime":"2016-12-05 17:00"},{"value":0,"datetime":"2016-12-05 18:00"},{"value":0,"datetime":"2016-12-05 19:00"},{"value":0,"datetime":"2016-12-05 20:00"},{"value":0,"datetime":"2016-12-05 21:00"},{"value":0,"datetime":"2016-12-05 22:00"},{"value":0,"datetime":"2016-12-05 23:00"},{"value":0,"datetime":"2016-12-06 00:00"},{"value":0,"datetime":"2016-12-06 01:00"},{"value":0,"datetime":"2016-12-06 02:00"},{"value":0,"datetime":"2016-12-06 03:00"},{"value":0,"datetime":"2016-12-06 04:00"},{"value":0,"datetime":"2016-12-06 05:00"},{"value":0,"datetime":"2016-12-06 06:00"},{"value":0,"datetime":"2016-12-06 07:00"},{"value":0,"datetime":"2016-12-06 08:00"},{"value":0,"datetime":"2016-12-06 09:00"},{"value":0,"datetime":"2016-12-06 10:00"},{"value":0,"datetime":"2016-12-06 11:00"},{"value":0,"datetime":"2016-12-06 12:00"},{"value":0,"datetime":"2016-12-06 13:00"},{"value":0,"datetime":"2016-12-06 14:00"},{"value":0,"datetime":"2016-12-06 15:00"},{"value":0,"datetime":"2016-12-06 16:00"},{"value":0,"datetime":"2016-12-06 17:00"},{"value":0,"datetime":"2016-12-06 18:00"},{"value":0,"datetime":"2016-12-06 19:00"},{"value":0,"datetime":"2016-12-06 20:00"},{"value":0,"datetime":"2016-12-06 21:00"},{"value":0,"datetime":"2016-12-06 22:00"},{"value":0,"datetime":"2016-12-06 23:00"},{"value":0,"datetime":"2016-12-07 00:00"},{"value":0,"datetime":"2016-12-07 01:00"},{"value":0,"datetime":"2016-12-07 02:00"},{"value":0,"datetime":"2016-12-07 03:00"},{"value":0,"datetime":"2016-12-07 04:00"},{"value":0,"datetime":"2016-12-07 05:00"},{"value":0,"datetime":"2016-12-07 06:00"},{"value":0,"datetime":"2016-12-07 07:00"},{"value":0,"datetime":"2016-12-07 08:00"},{"value":0,"datetime":"2016-12-07 09:00"},{"value":0,"datetime":"2016-12-07 10:00"}],"wind":[{"direction":344.02,"speed":10.37,"datetime":"2016-12-05 11:00"},{"direction":356.07,"speed":10.6,"datetime":"2016-12-05 12:00"},{"direction":13.44,"speed":11.65,"datetime":"2016-12-05 13:00"},{"direction":22.32,"speed":12.75,"datetime":"2016-12-05 14:00"},{"direction":17.98,"speed":12.21,"datetime":"2016-12-05 15:00"},{"direction":1.99,"speed":10.79,"datetime":"2016-12-05 16:00"},{"direction":338.3,"speed":10.13,"datetime":"2016-12-05 17:00"},{"direction":316.64,"speed":10.52,"datetime":"2016-12-05 18:00"},{"direction":301.43,"speed":11.24,"datetime":"2016-12-05 19:00"},{"direction":292.86,"speed":11.51,"datetime":"2016-12-05 20:00"},{"direction":290.32,"speed":10.87,"datetime":"2016-12-05 21:00"},{"direction":291.73,"speed":9.61,"datetime":"2016-12-05 22:00"},{"direction":294.76,"speed":8.28,"datetime":"2016-12-05 23:00"},{"direction":296.04,"speed":7.3,"datetime":"2016-12-06 00:00"},{"direction":293.61,"speed":6.55,"datetime":"2016-12-06 01:00"},{"direction":286.07,"speed":5.89,"datetime":"2016-12-06 02:00"},{"direction":272.27,"speed":5.39,"datetime":"2016-12-06 03:00"},{"direction":256.16,"speed":5.34,"datetime":"2016-12-06 04:00"},{"direction":244.86,"speed":5.68,"datetime":"2016-12-06 05:00"},{"direction":241.57,"speed":5.97,"datetime":"2016-12-06 06:00"},{"direction":244.25,"speed":5.96,"datetime":"2016-12-06 07:00"},{"direction":251.61,"speed":5.57,"datetime":"2016-12-06 08:00"},{"direction":264.19,"speed":4.92,"datetime":"2016-12-06 09:00"},{"direction":281.69,"speed":4.43,"datetime":"2016-12-06 10:00"},{"direction":298.47,"speed":4.39,"datetime":"2016-12-06 11:00"},{"direction":308.54,"speed":4.59,"datetime":"2016-12-06 12:00"},{"direction":315.98,"speed":4.8,"datetime":"2016-12-06 13:00"},{"direction":326.57,"speed":5.05,"datetime":"2016-12-06 14:00"},{"direction":341.98,"speed":5.68,"datetime":"2016-12-06 15:00"},{"direction":354.97,"speed":6.87,"datetime":"2016-12-06 16:00"},{"direction":1.43,"speed":8.29,"datetime":"2016-12-06 17:00"},{"direction":2.12,"speed":9.47,"datetime":"2016-12-06 18:00"},{"direction":0.61,"speed":10.25,"datetime":"2016-12-06 19:00"},{"direction":359.55,"speed":10.52,"datetime":"2016-12-06 20:00"},{"direction":0.48,"speed":10.21,"datetime":"2016-12-06 21:00"},{"direction":2.58,"speed":9.49,"datetime":"2016-12-06 22:00"},{"direction":4.24,"speed":8.61,"datetime":"2016-12-06 23:00"},{"direction":3.47,"speed":7.71,"datetime":"2016-12-07 00:00"},{"direction":359.41,"speed":6.84,"datetime":"2016-12-07 01:00"},{"direction":351.41,"speed":6.07,"datetime":"2016-12-07 02:00"},{"direction":339.48,"speed":5.53,"datetime":"2016-12-07 03:00"},{"direction":326.79,"speed":5.42,"datetime":"2016-12-07 04:00"},{"direction":318.36,"speed":5.65,"datetime":"2016-12-07 05:00"},{"direction":316.37,"speed":6.01,"datetime":"2016-12-07 06:00"},{"direction":317.68,"speed":6.3,"datetime":"2016-12-07 07:00"},{"direction":318.82,"speed":6.41,"datetime":"2016-12-07 08:00"},{"direction":317.59,"speed":6.23,"datetime":"2016-12-07 09:00"},{"direction":314.82,"speed":5.7,"datetime":"2016-12-07 10:00"}],"temperature":[{"value":10.96,"datetime":"2016-12-05 11:00"},{"value":12.61,"datetime":"2016-12-05 12:00"},{"value":14.14,"datetime":"2016-12-05 13:00"},{"value":15.37,"datetime":"2016-12-05 14:00"},{"value":16.11,"datetime":"2016-12-05 15:00"},{"value":16.18,"datetime":"2016-12-05 16:00"},{"value":15.41,"datetime":"2016-12-05 17:00"},{"value":13.75,"datetime":"2016-12-05 18:00"},{"value":11.77,"datetime":"2016-12-05 19:00"},{"value":10.15,"datetime":"2016-12-05 20:00"},{"value":9.39,"datetime":"2016-12-05 21:00"},{"value":9.23,"datetime":"2016-12-05 22:00"},{"value":9.2,"datetime":"2016-12-05 23:00"},{"value":8.94,"datetime":"2016-12-06 00:00"},{"value":8.55,"datetime":"2016-12-06 01:00"},{"value":8.22,"datetime":"2016-12-06 02:00"},{"value":8.07,"datetime":"2016-12-06 03:00"},{"value":7.9,"datetime":"2016-12-06 04:00"},{"value":7.44,"datetime":"2016-12-06 05:00"},{"value":6.6,"datetime":"2016-12-06 06:00"},{"value":5.98,"datetime":"2016-12-06 07:00"},{"value":6.35,"datetime":"2016-12-06 08:00"},{"value":8.22,"datetime":"2016-12-06 09:00"},{"value":10.86,"datetime":"2016-12-06 10:00"},{"value":13.29,"datetime":"2016-12-06 11:00"},{"value":14.74,"datetime":"2016-12-06 12:00"},{"value":15.4,"datetime":"2016-12-06 13:00"},{"value":15.69,"datetime":"2016-12-06 14:00"},{"value":15.89,"datetime":"2016-12-06 15:00"},{"value":15.8,"datetime":"2016-12-06 16:00"},{"value":15.08,"datetime":"2016-12-06 17:00"},{"value":13.56,"datetime":"2016-12-06 18:00"},{"value":11.7,"datetime":"2016-12-06 19:00"},{"value":10.11,"datetime":"2016-12-06 20:00"},{"value":9.26,"datetime":"2016-12-06 21:00"},{"value":8.92,"datetime":"2016-12-06 22:00"},{"value":8.71,"datetime":"2016-12-06 23:00"},{"value":8.33,"datetime":"2016-12-07 00:00"},{"value":7.86,"datetime":"2016-12-07 01:00"},{"value":7.43,"datetime":"2016-12-07 02:00"},{"value":7.14,"datetime":"2016-12-07 03:00"},{"value":6.85,"datetime":"2016-12-07 04:00"},{"value":6.39,"datetime":"2016-12-07 05:00"},{"value":5.7,"datetime":"2016-12-07 06:00"},{"value":5.27,"datetime":"2016-12-07 07:00"},{"value":5.74,"datetime":"2016-12-07 08:00"},{"value":7.51,"datetime":"2016-12-07 09:00"},{"value":10.01,"datetime":"2016-12-07 10:00"}]},"minutely":{"status":"ok","description":"未来两小时不会下雨，放心出门吧","probability":[0,0,0,0],"datasource":"radar","precipitation_2h":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"precipitation":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]},"daily":{"status":"ok","coldRisk":[{"index":"4","desc":"极易发","datetime":"2016-12-05"},{"index":"4","desc":"极易发","datetime":"2016-12-06"},{"index":"4","desc":"极易发","datetime":"2016-12-07"},{"index":"4","desc":"极易发","datetime":"2016-12-08"},{"index":"4","desc":"极易发","datetime":"2016-12-09"}],"temperature":[{"date":"2016-12-05","max":16.18,"avg":12.64,"min":6.88},{"date":"2016-12-06","max":15.89,"avg":10.64,"min":5.98},{"date":"2016-12-07","max":16.31,"avg":10.16,"min":5.27},{"date":"2016-12-08","max":15.74,"avg":9.51,"min":4.73},{"date":"2016-12-09","max":15.35,"avg":9.98,"min":5.62}],"skycon":[{"date":"2016-12-05","value":"CLEAR_DAY"},{"date":"2016-12-06","value":"CLEAR_DAY"},{"date":"2016-12-07","value":"CLEAR_DAY"},{"date":"2016-12-08","value":"CLEAR_DAY"},{"date":"2016-12-09","value":"CLEAR_DAY"}],"cloudrate":[{"date":"2016-12-05","max":0.67,"avg":0.19,"min":0},{"date":"2016-12-06","max":0.43,"avg":0.09,"min":0},{"date":"2016-12-07","max":0,"avg":0,"min":0},{"date":"2016-12-08","max":0.01,"avg":0,"min":0},{"date":"2016-12-09","max":0.21,"avg":0.1,"min":0}],"aqi":[{"date":"2016-12-05","max":271,"avg":148.69,"min":138},{"date":"2016-12-06","max":136,"avg":128.79,"min":122},{"date":"2016-12-07","max":122,"avg":117.25,"min":113},{"date":"2016-12-08","max":113,"avg":110.83,"min":108},{"date":"2016-12-09","max":108,"avg":106.92,"min":105}],"humidity":[{"date":"2016-12-05","max":0.97,"avg":0.49,"min":0.33},{"date":"2016-12-06","max":0.48,"avg":0.33,"min":0.25},{"date":"2016-12-07","max":0.6,"avg":0.47,"min":0.3},{"date":"2016-12-08","max":0.77,"avg":0.61,"min":0.4},{"date":"2016-12-09","max":0.92,"avg":0.74,"min":0.55}],"astro":[{"date":"2016-12-05","sunset":{"time":"18:01"},"sunrise":{"time":"07:46"}},{"date":"2016-12-06","sunset":{"time":"18:02"},"sunrise":{"time":"07:47"}},{"date":"2016-12-07","sunset":{"time":"18:02"},"sunrise":{"time":"07:47"}},{"date":"2016-12-08","sunset":{"time":"18:02"},"sunrise":{"time":"07:48"}},{"date":"2016-12-09","sunset":{"time":"18:02"},"sunrise":{"time":"07:49"}}],"ultraviolet":[{"index":"2","desc":"弱","datetime":"2016-12-05"},{"index":"4","desc":"强","datetime":"2016-12-06"},{"index":"4","desc":"强","datetime":"2016-12-07"},{"index":"4","desc":"强","datetime":"2016-12-08"},{"index":"4","desc":"强","datetime":"2016-12-09"}],"pm25":[{"date":"2016-12-05","max":221,"avg":113.38,"min":105},{"date":"2016-12-06","max":104,"avg":97.79,"min":92},{"date":"2016-12-07","max":92,"avg":88.29,"min":85},{"date":"2016-12-08","max":85,"avg":83.17,"min":81},{"date":"2016-12-09","max":81,"avg":79.92,"min":78}],"dressing":[{"index":"5","desc":"凉爽","datetime":"2016-12-05"},{"index":"5","desc":"凉爽","datetime":"2016-12-06"},{"index":"5","desc":"凉爽","datetime":"2016-12-07"},{"index":"6","desc":"冷","datetime":"2016-12-08"},{"index":"6","desc":"冷","datetime":"2016-12-09"}],"carWashing":[{"index":"2","desc":"较适宜","datetime":"2016-12-05"},{"index":"2","desc":"较适宜","datetime":"2016-12-06"},{"index":"2","desc":"较适宜","datetime":"2016-12-07"},{"index":"2","desc":"较适宜","datetime":"2016-12-08"},{"index":"2","desc":"较适宜","datetime":"2016-12-09"}],"precipitation":[{"date":"2016-12-05","max":0,"avg":0,"min":0},{"date":"2016-12-06","max":0,"avg":0,"min":0},{"date":"2016-12-07","max":0,"avg":0,"min":0},{"date":"2016-12-08","max":0,"avg":0,"min":0},{"date":"2016-12-09","max":0,"avg":0,"min":0}],"wind":[{"date":"2016-12-05","max":{"direction":22.32,"speed":12.75},"avg":{"direction":347.33,"speed":9.66},"min":{"direction":356.32,"speed":6.96}},{"date":"2016-12-06","max":{"direction":359.55,"speed":10.52},"avg":{"direction":320.5,"speed":6.72},"min":{"direction":298.47,"speed":4.39}},{"date":"2016-12-07","max":{"direction":307.71,"speed":11.74},"avg":{"direction":317.07,"speed":6.18},"min":{"direction":298.63,"speed":1.47}},{"date":"2016-12-08","max":{"direction":335.64,"speed":11.59},"avg":{"direction":355.63,"speed":7.91},"min":{"direction":315.29,"speed":5.16}},{"date":"2016-12-09","max":{"direction":345.18,"speed":13.69},"avg":{"direction":352.04,"speed":8.7},"min":{"direction":334.42,"speed":5.85}}]},"primary":0}
     * server_time : 1480909694
     * api_status : active
     * tzshift : 28800
     * api_version : v2.2
     * unit : metric
     * location : [30.675834,104.11106]
     */

    private String status;
    private String lang;
    /**
     * hourly : {"status":"ok","description":"未来24小时晴","skycon":[{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 11:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 12:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 13:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 14:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 15:00"},{"value":"CLEAR_DAY","datetime":"2016-12-05 16:00"},{"value":"CLEAR_DAY","datetime":"2016-12-05 17:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 18:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 19:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 20:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 21:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 22:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 23:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 00:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 01:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 02:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 03:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 04:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2016-12-06 05:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2016-12-06 06:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-06 07:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-06 08:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-06 09:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 10:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 11:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 12:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 13:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 14:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 15:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 16:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 17:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 18:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 19:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 20:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 21:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 22:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 23:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 00:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 01:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 02:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 03:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 04:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 05:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 06:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 07:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 08:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 09:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 10:00"}],"cloudrate":[{"value":0.67,"datetime":"2016-12-05 11:00"},{"value":0.61,"datetime":"2016-12-05 12:00"},{"value":0.5,"datetime":"2016-12-05 13:00"},{"value":0.36,"datetime":"2016-12-05 14:00"},{"value":0.21,"datetime":"2016-12-05 15:00"},{"value":0.08,"datetime":"2016-12-05 16:00"},{"value":0,"datetime":"2016-12-05 17:00"},{"value":0,"datetime":"2016-12-05 18:00"},{"value":0,"datetime":"2016-12-05 19:00"},{"value":0,"datetime":"2016-12-05 20:00"},{"value":0.01,"datetime":"2016-12-05 21:00"},{"value":0.01,"datetime":"2016-12-05 22:00"},{"value":0,"datetime":"2016-12-05 23:00"},{"value":0,"datetime":"2016-12-06 00:00"},{"value":0,"datetime":"2016-12-06 01:00"},{"value":0.03,"datetime":"2016-12-06 02:00"},{"value":0.1,"datetime":"2016-12-06 03:00"},{"value":0.19,"datetime":"2016-12-06 04:00"},{"value":0.29,"datetime":"2016-12-06 05:00"},{"value":0.38,"datetime":"2016-12-06 06:00"},{"value":0.43,"datetime":"2016-12-06 07:00"},{"value":0.4,"datetime":"2016-12-06 08:00"},{"value":0.29,"datetime":"2016-12-06 09:00"},{"value":0.13,"datetime":"2016-12-06 10:00"},{"value":0,"datetime":"2016-12-06 11:00"},{"value":0,"datetime":"2016-12-06 12:00"},{"value":0,"datetime":"2016-12-06 13:00"},{"value":0,"datetime":"2016-12-06 14:00"},{"value":0.01,"datetime":"2016-12-06 15:00"},{"value":0.01,"datetime":"2016-12-06 16:00"},{"value":0,"datetime":"2016-12-06 17:00"},{"value":0,"datetime":"2016-12-06 18:00"},{"value":0,"datetime":"2016-12-06 19:00"},{"value":0,"datetime":"2016-12-06 20:00"},{"value":0,"datetime":"2016-12-06 21:00"},{"value":0,"datetime":"2016-12-06 22:00"},{"value":0,"datetime":"2016-12-06 23:00"},{"value":0,"datetime":"2016-12-07 00:00"},{"value":0,"datetime":"2016-12-07 01:00"},{"value":0,"datetime":"2016-12-07 02:00"},{"value":0,"datetime":"2016-12-07 03:00"},{"value":0,"datetime":"2016-12-07 04:00"},{"value":0,"datetime":"2016-12-07 05:00"},{"value":0,"datetime":"2016-12-07 06:00"},{"value":0,"datetime":"2016-12-07 07:00"},{"value":0,"datetime":"2016-12-07 08:00"},{"value":0,"datetime":"2016-12-07 09:00"},{"value":0,"datetime":"2016-12-07 10:00"}],"aqi":[{"value":179,"datetime":"2016-12-05 11:00"},{"value":165,"datetime":"2016-12-05 12:00"},{"value":155,"datetime":"2016-12-05 13:00"},{"value":150,"datetime":"2016-12-05 14:00"},{"value":148,"datetime":"2016-12-05 15:00"},{"value":146,"datetime":"2016-12-05 16:00"},{"value":145,"datetime":"2016-12-05 17:00"},{"value":144,"datetime":"2016-12-05 18:00"},{"value":143,"datetime":"2016-12-05 19:00"},{"value":141,"datetime":"2016-12-05 20:00"},{"value":140,"datetime":"2016-12-05 21:00"},{"value":139,"datetime":"2016-12-05 22:00"},{"value":138,"datetime":"2016-12-05 23:00"},{"value":136,"datetime":"2016-12-06 00:00"},{"value":136,"datetime":"2016-12-06 01:00"},{"value":135,"datetime":"2016-12-06 02:00"},{"value":134,"datetime":"2016-12-06 03:00"},{"value":134,"datetime":"2016-12-06 04:00"},{"value":133,"datetime":"2016-12-06 05:00"},{"value":132,"datetime":"2016-12-06 06:00"},{"value":132,"datetime":"2016-12-06 07:00"},{"value":130,"datetime":"2016-12-06 08:00"},{"value":130,"datetime":"2016-12-06 09:00"},{"value":130,"datetime":"2016-12-06 10:00"},{"value":129,"datetime":"2016-12-06 11:00"},{"value":129,"datetime":"2016-12-06 12:00"},{"value":128,"datetime":"2016-12-06 13:00"},{"value":127,"datetime":"2016-12-06 14:00"},{"value":127,"datetime":"2016-12-06 15:00"},{"value":125,"datetime":"2016-12-06 16:00"},{"value":125,"datetime":"2016-12-06 17:00"},{"value":125,"datetime":"2016-12-06 18:00"},{"value":124,"datetime":"2016-12-06 19:00"},{"value":123,"datetime":"2016-12-06 20:00"},{"value":123,"datetime":"2016-12-06 21:00"},{"value":122,"datetime":"2016-12-06 22:00"},{"value":122,"datetime":"2016-12-06 23:00"},{"value":122,"datetime":"2016-12-07 00:00"},{"value":122,"datetime":"2016-12-07 01:00"},{"value":121,"datetime":"2016-12-07 02:00"},{"value":121,"datetime":"2016-12-07 03:00"},{"value":121,"datetime":"2016-12-07 04:00"},{"value":119,"datetime":"2016-12-07 05:00"},{"value":119,"datetime":"2016-12-07 06:00"},{"value":118,"datetime":"2016-12-07 07:00"},{"value":118,"datetime":"2016-12-07 08:00"},{"value":118,"datetime":"2016-12-07 09:00"},{"value":118,"datetime":"2016-12-07 10:00"}],"humidity":[{"value":0.72,"datetime":"2016-12-05 11:00"},{"value":0.62,"datetime":"2016-12-05 12:00"},{"value":0.52,"datetime":"2016-12-05 13:00"},{"value":0.44,"datetime":"2016-12-05 14:00"},{"value":0.37,"datetime":"2016-12-05 15:00"},{"value":0.33,"datetime":"2016-12-05 16:00"},{"value":0.34,"datetime":"2016-12-05 17:00"},{"value":0.42,"datetime":"2016-12-05 18:00"},{"value":0.52,"datetime":"2016-12-05 19:00"},{"value":0.57,"datetime":"2016-12-05 20:00"},{"value":0.56,"datetime":"2016-12-05 21:00"},{"value":0.49,"datetime":"2016-12-05 22:00"},{"value":0.41,"datetime":"2016-12-05 23:00"},{"value":0.36,"datetime":"2016-12-06 00:00"},{"value":0.34,"datetime":"2016-12-06 01:00"},{"value":0.32,"datetime":"2016-12-06 02:00"},{"value":0.31,"datetime":"2016-12-06 03:00"},{"value":0.31,"datetime":"2016-12-06 04:00"},{"value":0.32,"datetime":"2016-12-06 05:00"},{"value":0.35,"datetime":"2016-12-06 06:00"},{"value":0.38,"datetime":"2016-12-06 07:00"},{"value":0.38,"datetime":"2016-12-06 08:00"},{"value":0.35,"datetime":"2016-12-06 09:00"},{"value":0.3,"datetime":"2016-12-06 10:00"},{"value":0.26,"datetime":"2016-12-06 11:00"},{"value":0.25,"datetime":"2016-12-06 12:00"},{"value":0.25,"datetime":"2016-12-06 13:00"},{"value":0.26,"datetime":"2016-12-06 14:00"},{"value":0.26,"datetime":"2016-12-06 15:00"},{"value":0.27,"datetime":"2016-12-06 16:00"},{"value":0.28,"datetime":"2016-12-06 17:00"},{"value":0.32,"datetime":"2016-12-06 18:00"},{"value":0.36,"datetime":"2016-12-06 19:00"},{"value":0.4,"datetime":"2016-12-06 20:00"},{"value":0.43,"datetime":"2016-12-06 21:00"},{"value":0.46,"datetime":"2016-12-06 22:00"},{"value":0.48,"datetime":"2016-12-06 23:00"},{"value":0.5,"datetime":"2016-12-07 00:00"},{"value":0.52,"datetime":"2016-12-07 01:00"},{"value":0.53,"datetime":"2016-12-07 02:00"},{"value":0.54,"datetime":"2016-12-07 03:00"},{"value":0.55,"datetime":"2016-12-07 04:00"},{"value":0.56,"datetime":"2016-12-07 05:00"},{"value":0.58,"datetime":"2016-12-07 06:00"},{"value":0.6,"datetime":"2016-12-07 07:00"},{"value":0.58,"datetime":"2016-12-07 08:00"},{"value":0.54,"datetime":"2016-12-07 09:00"},{"value":0.47,"datetime":"2016-12-07 10:00"}],"pm25":[{"value":135,"datetime":"2016-12-05 11:00"},{"value":125,"datetime":"2016-12-05 12:00"},{"value":118,"datetime":"2016-12-05 13:00"},{"value":115,"datetime":"2016-12-05 14:00"},{"value":113,"datetime":"2016-12-05 15:00"},{"value":112,"datetime":"2016-12-05 16:00"},{"value":111,"datetime":"2016-12-05 17:00"},{"value":110,"datetime":"2016-12-05 18:00"},{"value":109,"datetime":"2016-12-05 19:00"},{"value":108,"datetime":"2016-12-05 20:00"},{"value":107,"datetime":"2016-12-05 21:00"},{"value":106,"datetime":"2016-12-05 22:00"},{"value":105,"datetime":"2016-12-05 23:00"},{"value":104,"datetime":"2016-12-06 00:00"},{"value":104,"datetime":"2016-12-06 01:00"},{"value":103,"datetime":"2016-12-06 02:00"},{"value":102,"datetime":"2016-12-06 03:00"},{"value":102,"datetime":"2016-12-06 04:00"},{"value":101,"datetime":"2016-12-06 05:00"},{"value":100,"datetime":"2016-12-06 06:00"},{"value":100,"datetime":"2016-12-06 07:00"},{"value":99,"datetime":"2016-12-06 08:00"},{"value":99,"datetime":"2016-12-06 09:00"},{"value":99,"datetime":"2016-12-06 10:00"},{"value":98,"datetime":"2016-12-06 11:00"},{"value":98,"datetime":"2016-12-06 12:00"},{"value":97,"datetime":"2016-12-06 13:00"},{"value":96,"datetime":"2016-12-06 14:00"},{"value":96,"datetime":"2016-12-06 15:00"},{"value":95,"datetime":"2016-12-06 16:00"},{"value":95,"datetime":"2016-12-06 17:00"},{"value":95,"datetime":"2016-12-06 18:00"},{"value":94,"datetime":"2016-12-06 19:00"},{"value":93,"datetime":"2016-12-06 20:00"},{"value":93,"datetime":"2016-12-06 21:00"},{"value":92,"datetime":"2016-12-06 22:00"},{"value":92,"datetime":"2016-12-06 23:00"},{"value":92,"datetime":"2016-12-07 00:00"},{"value":92,"datetime":"2016-12-07 01:00"},{"value":91,"datetime":"2016-12-07 02:00"},{"value":91,"datetime":"2016-12-07 03:00"},{"value":91,"datetime":"2016-12-07 04:00"},{"value":90,"datetime":"2016-12-07 05:00"},{"value":90,"datetime":"2016-12-07 06:00"},{"value":89,"datetime":"2016-12-07 07:00"},{"value":89,"datetime":"2016-12-07 08:00"},{"value":89,"datetime":"2016-12-07 09:00"},{"value":89,"datetime":"2016-12-07 10:00"}],"precipitation":[{"value":0,"datetime":"2016-12-05 11:00"},{"value":0,"datetime":"2016-12-05 12:00"},{"value":0,"datetime":"2016-12-05 13:00"},{"value":0,"datetime":"2016-12-05 14:00"},{"value":0,"datetime":"2016-12-05 15:00"},{"value":0,"datetime":"2016-12-05 16:00"},{"value":0,"datetime":"2016-12-05 17:00"},{"value":0,"datetime":"2016-12-05 18:00"},{"value":0,"datetime":"2016-12-05 19:00"},{"value":0,"datetime":"2016-12-05 20:00"},{"value":0,"datetime":"2016-12-05 21:00"},{"value":0,"datetime":"2016-12-05 22:00"},{"value":0,"datetime":"2016-12-05 23:00"},{"value":0,"datetime":"2016-12-06 00:00"},{"value":0,"datetime":"2016-12-06 01:00"},{"value":0,"datetime":"2016-12-06 02:00"},{"value":0,"datetime":"2016-12-06 03:00"},{"value":0,"datetime":"2016-12-06 04:00"},{"value":0,"datetime":"2016-12-06 05:00"},{"value":0,"datetime":"2016-12-06 06:00"},{"value":0,"datetime":"2016-12-06 07:00"},{"value":0,"datetime":"2016-12-06 08:00"},{"value":0,"datetime":"2016-12-06 09:00"},{"value":0,"datetime":"2016-12-06 10:00"},{"value":0,"datetime":"2016-12-06 11:00"},{"value":0,"datetime":"2016-12-06 12:00"},{"value":0,"datetime":"2016-12-06 13:00"},{"value":0,"datetime":"2016-12-06 14:00"},{"value":0,"datetime":"2016-12-06 15:00"},{"value":0,"datetime":"2016-12-06 16:00"},{"value":0,"datetime":"2016-12-06 17:00"},{"value":0,"datetime":"2016-12-06 18:00"},{"value":0,"datetime":"2016-12-06 19:00"},{"value":0,"datetime":"2016-12-06 20:00"},{"value":0,"datetime":"2016-12-06 21:00"},{"value":0,"datetime":"2016-12-06 22:00"},{"value":0,"datetime":"2016-12-06 23:00"},{"value":0,"datetime":"2016-12-07 00:00"},{"value":0,"datetime":"2016-12-07 01:00"},{"value":0,"datetime":"2016-12-07 02:00"},{"value":0,"datetime":"2016-12-07 03:00"},{"value":0,"datetime":"2016-12-07 04:00"},{"value":0,"datetime":"2016-12-07 05:00"},{"value":0,"datetime":"2016-12-07 06:00"},{"value":0,"datetime":"2016-12-07 07:00"},{"value":0,"datetime":"2016-12-07 08:00"},{"value":0,"datetime":"2016-12-07 09:00"},{"value":0,"datetime":"2016-12-07 10:00"}],"wind":[{"direction":344.02,"speed":10.37,"datetime":"2016-12-05 11:00"},{"direction":356.07,"speed":10.6,"datetime":"2016-12-05 12:00"},{"direction":13.44,"speed":11.65,"datetime":"2016-12-05 13:00"},{"direction":22.32,"speed":12.75,"datetime":"2016-12-05 14:00"},{"direction":17.98,"speed":12.21,"datetime":"2016-12-05 15:00"},{"direction":1.99,"speed":10.79,"datetime":"2016-12-05 16:00"},{"direction":338.3,"speed":10.13,"datetime":"2016-12-05 17:00"},{"direction":316.64,"speed":10.52,"datetime":"2016-12-05 18:00"},{"direction":301.43,"speed":11.24,"datetime":"2016-12-05 19:00"},{"direction":292.86,"speed":11.51,"datetime":"2016-12-05 20:00"},{"direction":290.32,"speed":10.87,"datetime":"2016-12-05 21:00"},{"direction":291.73,"speed":9.61,"datetime":"2016-12-05 22:00"},{"direction":294.76,"speed":8.28,"datetime":"2016-12-05 23:00"},{"direction":296.04,"speed":7.3,"datetime":"2016-12-06 00:00"},{"direction":293.61,"speed":6.55,"datetime":"2016-12-06 01:00"},{"direction":286.07,"speed":5.89,"datetime":"2016-12-06 02:00"},{"direction":272.27,"speed":5.39,"datetime":"2016-12-06 03:00"},{"direction":256.16,"speed":5.34,"datetime":"2016-12-06 04:00"},{"direction":244.86,"speed":5.68,"datetime":"2016-12-06 05:00"},{"direction":241.57,"speed":5.97,"datetime":"2016-12-06 06:00"},{"direction":244.25,"speed":5.96,"datetime":"2016-12-06 07:00"},{"direction":251.61,"speed":5.57,"datetime":"2016-12-06 08:00"},{"direction":264.19,"speed":4.92,"datetime":"2016-12-06 09:00"},{"direction":281.69,"speed":4.43,"datetime":"2016-12-06 10:00"},{"direction":298.47,"speed":4.39,"datetime":"2016-12-06 11:00"},{"direction":308.54,"speed":4.59,"datetime":"2016-12-06 12:00"},{"direction":315.98,"speed":4.8,"datetime":"2016-12-06 13:00"},{"direction":326.57,"speed":5.05,"datetime":"2016-12-06 14:00"},{"direction":341.98,"speed":5.68,"datetime":"2016-12-06 15:00"},{"direction":354.97,"speed":6.87,"datetime":"2016-12-06 16:00"},{"direction":1.43,"speed":8.29,"datetime":"2016-12-06 17:00"},{"direction":2.12,"speed":9.47,"datetime":"2016-12-06 18:00"},{"direction":0.61,"speed":10.25,"datetime":"2016-12-06 19:00"},{"direction":359.55,"speed":10.52,"datetime":"2016-12-06 20:00"},{"direction":0.48,"speed":10.21,"datetime":"2016-12-06 21:00"},{"direction":2.58,"speed":9.49,"datetime":"2016-12-06 22:00"},{"direction":4.24,"speed":8.61,"datetime":"2016-12-06 23:00"},{"direction":3.47,"speed":7.71,"datetime":"2016-12-07 00:00"},{"direction":359.41,"speed":6.84,"datetime":"2016-12-07 01:00"},{"direction":351.41,"speed":6.07,"datetime":"2016-12-07 02:00"},{"direction":339.48,"speed":5.53,"datetime":"2016-12-07 03:00"},{"direction":326.79,"speed":5.42,"datetime":"2016-12-07 04:00"},{"direction":318.36,"speed":5.65,"datetime":"2016-12-07 05:00"},{"direction":316.37,"speed":6.01,"datetime":"2016-12-07 06:00"},{"direction":317.68,"speed":6.3,"datetime":"2016-12-07 07:00"},{"direction":318.82,"speed":6.41,"datetime":"2016-12-07 08:00"},{"direction":317.59,"speed":6.23,"datetime":"2016-12-07 09:00"},{"direction":314.82,"speed":5.7,"datetime":"2016-12-07 10:00"}],"temperature":[{"value":10.96,"datetime":"2016-12-05 11:00"},{"value":12.61,"datetime":"2016-12-05 12:00"},{"value":14.14,"datetime":"2016-12-05 13:00"},{"value":15.37,"datetime":"2016-12-05 14:00"},{"value":16.11,"datetime":"2016-12-05 15:00"},{"value":16.18,"datetime":"2016-12-05 16:00"},{"value":15.41,"datetime":"2016-12-05 17:00"},{"value":13.75,"datetime":"2016-12-05 18:00"},{"value":11.77,"datetime":"2016-12-05 19:00"},{"value":10.15,"datetime":"2016-12-05 20:00"},{"value":9.39,"datetime":"2016-12-05 21:00"},{"value":9.23,"datetime":"2016-12-05 22:00"},{"value":9.2,"datetime":"2016-12-05 23:00"},{"value":8.94,"datetime":"2016-12-06 00:00"},{"value":8.55,"datetime":"2016-12-06 01:00"},{"value":8.22,"datetime":"2016-12-06 02:00"},{"value":8.07,"datetime":"2016-12-06 03:00"},{"value":7.9,"datetime":"2016-12-06 04:00"},{"value":7.44,"datetime":"2016-12-06 05:00"},{"value":6.6,"datetime":"2016-12-06 06:00"},{"value":5.98,"datetime":"2016-12-06 07:00"},{"value":6.35,"datetime":"2016-12-06 08:00"},{"value":8.22,"datetime":"2016-12-06 09:00"},{"value":10.86,"datetime":"2016-12-06 10:00"},{"value":13.29,"datetime":"2016-12-06 11:00"},{"value":14.74,"datetime":"2016-12-06 12:00"},{"value":15.4,"datetime":"2016-12-06 13:00"},{"value":15.69,"datetime":"2016-12-06 14:00"},{"value":15.89,"datetime":"2016-12-06 15:00"},{"value":15.8,"datetime":"2016-12-06 16:00"},{"value":15.08,"datetime":"2016-12-06 17:00"},{"value":13.56,"datetime":"2016-12-06 18:00"},{"value":11.7,"datetime":"2016-12-06 19:00"},{"value":10.11,"datetime":"2016-12-06 20:00"},{"value":9.26,"datetime":"2016-12-06 21:00"},{"value":8.92,"datetime":"2016-12-06 22:00"},{"value":8.71,"datetime":"2016-12-06 23:00"},{"value":8.33,"datetime":"2016-12-07 00:00"},{"value":7.86,"datetime":"2016-12-07 01:00"},{"value":7.43,"datetime":"2016-12-07 02:00"},{"value":7.14,"datetime":"2016-12-07 03:00"},{"value":6.85,"datetime":"2016-12-07 04:00"},{"value":6.39,"datetime":"2016-12-07 05:00"},{"value":5.7,"datetime":"2016-12-07 06:00"},{"value":5.27,"datetime":"2016-12-07 07:00"},{"value":5.74,"datetime":"2016-12-07 08:00"},{"value":7.51,"datetime":"2016-12-07 09:00"},{"value":10.01,"datetime":"2016-12-07 10:00"}]}
     * minutely : {"status":"ok","description":"未来两小时不会下雨，放心出门吧","probability":[0,0,0,0],"datasource":"radar","precipitation_2h":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],"precipitation":[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]}
     * daily : {"status":"ok","coldRisk":[{"index":"4","desc":"极易发","datetime":"2016-12-05"},{"index":"4","desc":"极易发","datetime":"2016-12-06"},{"index":"4","desc":"极易发","datetime":"2016-12-07"},{"index":"4","desc":"极易发","datetime":"2016-12-08"},{"index":"4","desc":"极易发","datetime":"2016-12-09"}],"temperature":[{"date":"2016-12-05","max":16.18,"avg":12.64,"min":6.88},{"date":"2016-12-06","max":15.89,"avg":10.64,"min":5.98},{"date":"2016-12-07","max":16.31,"avg":10.16,"min":5.27},{"date":"2016-12-08","max":15.74,"avg":9.51,"min":4.73},{"date":"2016-12-09","max":15.35,"avg":9.98,"min":5.62}],"skycon":[{"date":"2016-12-05","value":"CLEAR_DAY"},{"date":"2016-12-06","value":"CLEAR_DAY"},{"date":"2016-12-07","value":"CLEAR_DAY"},{"date":"2016-12-08","value":"CLEAR_DAY"},{"date":"2016-12-09","value":"CLEAR_DAY"}],"cloudrate":[{"date":"2016-12-05","max":0.67,"avg":0.19,"min":0},{"date":"2016-12-06","max":0.43,"avg":0.09,"min":0},{"date":"2016-12-07","max":0,"avg":0,"min":0},{"date":"2016-12-08","max":0.01,"avg":0,"min":0},{"date":"2016-12-09","max":0.21,"avg":0.1,"min":0}],"aqi":[{"date":"2016-12-05","max":271,"avg":148.69,"min":138},{"date":"2016-12-06","max":136,"avg":128.79,"min":122},{"date":"2016-12-07","max":122,"avg":117.25,"min":113},{"date":"2016-12-08","max":113,"avg":110.83,"min":108},{"date":"2016-12-09","max":108,"avg":106.92,"min":105}],"humidity":[{"date":"2016-12-05","max":0.97,"avg":0.49,"min":0.33},{"date":"2016-12-06","max":0.48,"avg":0.33,"min":0.25},{"date":"2016-12-07","max":0.6,"avg":0.47,"min":0.3},{"date":"2016-12-08","max":0.77,"avg":0.61,"min":0.4},{"date":"2016-12-09","max":0.92,"avg":0.74,"min":0.55}],"astro":[{"date":"2016-12-05","sunset":{"time":"18:01"},"sunrise":{"time":"07:46"}},{"date":"2016-12-06","sunset":{"time":"18:02"},"sunrise":{"time":"07:47"}},{"date":"2016-12-07","sunset":{"time":"18:02"},"sunrise":{"time":"07:47"}},{"date":"2016-12-08","sunset":{"time":"18:02"},"sunrise":{"time":"07:48"}},{"date":"2016-12-09","sunset":{"time":"18:02"},"sunrise":{"time":"07:49"}}],"ultraviolet":[{"index":"2","desc":"弱","datetime":"2016-12-05"},{"index":"4","desc":"强","datetime":"2016-12-06"},{"index":"4","desc":"强","datetime":"2016-12-07"},{"index":"4","desc":"强","datetime":"2016-12-08"},{"index":"4","desc":"强","datetime":"2016-12-09"}],"pm25":[{"date":"2016-12-05","max":221,"avg":113.38,"min":105},{"date":"2016-12-06","max":104,"avg":97.79,"min":92},{"date":"2016-12-07","max":92,"avg":88.29,"min":85},{"date":"2016-12-08","max":85,"avg":83.17,"min":81},{"date":"2016-12-09","max":81,"avg":79.92,"min":78}],"dressing":[{"index":"5","desc":"凉爽","datetime":"2016-12-05"},{"index":"5","desc":"凉爽","datetime":"2016-12-06"},{"index":"5","desc":"凉爽","datetime":"2016-12-07"},{"index":"6","desc":"冷","datetime":"2016-12-08"},{"index":"6","desc":"冷","datetime":"2016-12-09"}],"carWashing":[{"index":"2","desc":"较适宜","datetime":"2016-12-05"},{"index":"2","desc":"较适宜","datetime":"2016-12-06"},{"index":"2","desc":"较适宜","datetime":"2016-12-07"},{"index":"2","desc":"较适宜","datetime":"2016-12-08"},{"index":"2","desc":"较适宜","datetime":"2016-12-09"}],"precipitation":[{"date":"2016-12-05","max":0,"avg":0,"min":0},{"date":"2016-12-06","max":0,"avg":0,"min":0},{"date":"2016-12-07","max":0,"avg":0,"min":0},{"date":"2016-12-08","max":0,"avg":0,"min":0},{"date":"2016-12-09","max":0,"avg":0,"min":0}],"wind":[{"date":"2016-12-05","max":{"direction":22.32,"speed":12.75},"avg":{"direction":347.33,"speed":9.66},"min":{"direction":356.32,"speed":6.96}},{"date":"2016-12-06","max":{"direction":359.55,"speed":10.52},"avg":{"direction":320.5,"speed":6.72},"min":{"direction":298.47,"speed":4.39}},{"date":"2016-12-07","max":{"direction":307.71,"speed":11.74},"avg":{"direction":317.07,"speed":6.18},"min":{"direction":298.63,"speed":1.47}},{"date":"2016-12-08","max":{"direction":335.64,"speed":11.59},"avg":{"direction":355.63,"speed":7.91},"min":{"direction":315.29,"speed":5.16}},{"date":"2016-12-09","max":{"direction":345.18,"speed":13.69},"avg":{"direction":352.04,"speed":8.7},"min":{"direction":334.42,"speed":5.85}}]}
     * primary : 0
     */

    private ResultBean result;
    private int server_time;
    private String api_status;
    private int tzshift;
    private String api_version;
    private String unit;
    private List<Double> location;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * status : ok
         * description : 未来24小时晴
         * skycon : [{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 11:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 12:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 13:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 14:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-05 15:00"},{"value":"CLEAR_DAY","datetime":"2016-12-05 16:00"},{"value":"CLEAR_DAY","datetime":"2016-12-05 17:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 18:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 19:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 20:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 21:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 22:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-05 23:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 00:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 01:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 02:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 03:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 04:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2016-12-06 05:00"},{"value":"PARTLY_CLOUDY_NIGHT","datetime":"2016-12-06 06:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-06 07:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-06 08:00"},{"value":"PARTLY_CLOUDY_DAY","datetime":"2016-12-06 09:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 10:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 11:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 12:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 13:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 14:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 15:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 16:00"},{"value":"CLEAR_DAY","datetime":"2016-12-06 17:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 18:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 19:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 20:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 21:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 22:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-06 23:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 00:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 01:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 02:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 03:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 04:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 05:00"},{"value":"CLEAR_NIGHT","datetime":"2016-12-07 06:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 07:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 08:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 09:00"},{"value":"CLEAR_DAY","datetime":"2016-12-07 10:00"}]
         * cloudrate : [{"value":0.67,"datetime":"2016-12-05 11:00"},{"value":0.61,"datetime":"2016-12-05 12:00"},{"value":0.5,"datetime":"2016-12-05 13:00"},{"value":0.36,"datetime":"2016-12-05 14:00"},{"value":0.21,"datetime":"2016-12-05 15:00"},{"value":0.08,"datetime":"2016-12-05 16:00"},{"value":0,"datetime":"2016-12-05 17:00"},{"value":0,"datetime":"2016-12-05 18:00"},{"value":0,"datetime":"2016-12-05 19:00"},{"value":0,"datetime":"2016-12-05 20:00"},{"value":0.01,"datetime":"2016-12-05 21:00"},{"value":0.01,"datetime":"2016-12-05 22:00"},{"value":0,"datetime":"2016-12-05 23:00"},{"value":0,"datetime":"2016-12-06 00:00"},{"value":0,"datetime":"2016-12-06 01:00"},{"value":0.03,"datetime":"2016-12-06 02:00"},{"value":0.1,"datetime":"2016-12-06 03:00"},{"value":0.19,"datetime":"2016-12-06 04:00"},{"value":0.29,"datetime":"2016-12-06 05:00"},{"value":0.38,"datetime":"2016-12-06 06:00"},{"value":0.43,"datetime":"2016-12-06 07:00"},{"value":0.4,"datetime":"2016-12-06 08:00"},{"value":0.29,"datetime":"2016-12-06 09:00"},{"value":0.13,"datetime":"2016-12-06 10:00"},{"value":0,"datetime":"2016-12-06 11:00"},{"value":0,"datetime":"2016-12-06 12:00"},{"value":0,"datetime":"2016-12-06 13:00"},{"value":0,"datetime":"2016-12-06 14:00"},{"value":0.01,"datetime":"2016-12-06 15:00"},{"value":0.01,"datetime":"2016-12-06 16:00"},{"value":0,"datetime":"2016-12-06 17:00"},{"value":0,"datetime":"2016-12-06 18:00"},{"value":0,"datetime":"2016-12-06 19:00"},{"value":0,"datetime":"2016-12-06 20:00"},{"value":0,"datetime":"2016-12-06 21:00"},{"value":0,"datetime":"2016-12-06 22:00"},{"value":0,"datetime":"2016-12-06 23:00"},{"value":0,"datetime":"2016-12-07 00:00"},{"value":0,"datetime":"2016-12-07 01:00"},{"value":0,"datetime":"2016-12-07 02:00"},{"value":0,"datetime":"2016-12-07 03:00"},{"value":0,"datetime":"2016-12-07 04:00"},{"value":0,"datetime":"2016-12-07 05:00"},{"value":0,"datetime":"2016-12-07 06:00"},{"value":0,"datetime":"2016-12-07 07:00"},{"value":0,"datetime":"2016-12-07 08:00"},{"value":0,"datetime":"2016-12-07 09:00"},{"value":0,"datetime":"2016-12-07 10:00"}]
         * aqi : [{"value":179,"datetime":"2016-12-05 11:00"},{"value":165,"datetime":"2016-12-05 12:00"},{"value":155,"datetime":"2016-12-05 13:00"},{"value":150,"datetime":"2016-12-05 14:00"},{"value":148,"datetime":"2016-12-05 15:00"},{"value":146,"datetime":"2016-12-05 16:00"},{"value":145,"datetime":"2016-12-05 17:00"},{"value":144,"datetime":"2016-12-05 18:00"},{"value":143,"datetime":"2016-12-05 19:00"},{"value":141,"datetime":"2016-12-05 20:00"},{"value":140,"datetime":"2016-12-05 21:00"},{"value":139,"datetime":"2016-12-05 22:00"},{"value":138,"datetime":"2016-12-05 23:00"},{"value":136,"datetime":"2016-12-06 00:00"},{"value":136,"datetime":"2016-12-06 01:00"},{"value":135,"datetime":"2016-12-06 02:00"},{"value":134,"datetime":"2016-12-06 03:00"},{"value":134,"datetime":"2016-12-06 04:00"},{"value":133,"datetime":"2016-12-06 05:00"},{"value":132,"datetime":"2016-12-06 06:00"},{"value":132,"datetime":"2016-12-06 07:00"},{"value":130,"datetime":"2016-12-06 08:00"},{"value":130,"datetime":"2016-12-06 09:00"},{"value":130,"datetime":"2016-12-06 10:00"},{"value":129,"datetime":"2016-12-06 11:00"},{"value":129,"datetime":"2016-12-06 12:00"},{"value":128,"datetime":"2016-12-06 13:00"},{"value":127,"datetime":"2016-12-06 14:00"},{"value":127,"datetime":"2016-12-06 15:00"},{"value":125,"datetime":"2016-12-06 16:00"},{"value":125,"datetime":"2016-12-06 17:00"},{"value":125,"datetime":"2016-12-06 18:00"},{"value":124,"datetime":"2016-12-06 19:00"},{"value":123,"datetime":"2016-12-06 20:00"},{"value":123,"datetime":"2016-12-06 21:00"},{"value":122,"datetime":"2016-12-06 22:00"},{"value":122,"datetime":"2016-12-06 23:00"},{"value":122,"datetime":"2016-12-07 00:00"},{"value":122,"datetime":"2016-12-07 01:00"},{"value":121,"datetime":"2016-12-07 02:00"},{"value":121,"datetime":"2016-12-07 03:00"},{"value":121,"datetime":"2016-12-07 04:00"},{"value":119,"datetime":"2016-12-07 05:00"},{"value":119,"datetime":"2016-12-07 06:00"},{"value":118,"datetime":"2016-12-07 07:00"},{"value":118,"datetime":"2016-12-07 08:00"},{"value":118,"datetime":"2016-12-07 09:00"},{"value":118,"datetime":"2016-12-07 10:00"}]
         * humidity : [{"value":0.72,"datetime":"2016-12-05 11:00"},{"value":0.62,"datetime":"2016-12-05 12:00"},{"value":0.52,"datetime":"2016-12-05 13:00"},{"value":0.44,"datetime":"2016-12-05 14:00"},{"value":0.37,"datetime":"2016-12-05 15:00"},{"value":0.33,"datetime":"2016-12-05 16:00"},{"value":0.34,"datetime":"2016-12-05 17:00"},{"value":0.42,"datetime":"2016-12-05 18:00"},{"value":0.52,"datetime":"2016-12-05 19:00"},{"value":0.57,"datetime":"2016-12-05 20:00"},{"value":0.56,"datetime":"2016-12-05 21:00"},{"value":0.49,"datetime":"2016-12-05 22:00"},{"value":0.41,"datetime":"2016-12-05 23:00"},{"value":0.36,"datetime":"2016-12-06 00:00"},{"value":0.34,"datetime":"2016-12-06 01:00"},{"value":0.32,"datetime":"2016-12-06 02:00"},{"value":0.31,"datetime":"2016-12-06 03:00"},{"value":0.31,"datetime":"2016-12-06 04:00"},{"value":0.32,"datetime":"2016-12-06 05:00"},{"value":0.35,"datetime":"2016-12-06 06:00"},{"value":0.38,"datetime":"2016-12-06 07:00"},{"value":0.38,"datetime":"2016-12-06 08:00"},{"value":0.35,"datetime":"2016-12-06 09:00"},{"value":0.3,"datetime":"2016-12-06 10:00"},{"value":0.26,"datetime":"2016-12-06 11:00"},{"value":0.25,"datetime":"2016-12-06 12:00"},{"value":0.25,"datetime":"2016-12-06 13:00"},{"value":0.26,"datetime":"2016-12-06 14:00"},{"value":0.26,"datetime":"2016-12-06 15:00"},{"value":0.27,"datetime":"2016-12-06 16:00"},{"value":0.28,"datetime":"2016-12-06 17:00"},{"value":0.32,"datetime":"2016-12-06 18:00"},{"value":0.36,"datetime":"2016-12-06 19:00"},{"value":0.4,"datetime":"2016-12-06 20:00"},{"value":0.43,"datetime":"2016-12-06 21:00"},{"value":0.46,"datetime":"2016-12-06 22:00"},{"value":0.48,"datetime":"2016-12-06 23:00"},{"value":0.5,"datetime":"2016-12-07 00:00"},{"value":0.52,"datetime":"2016-12-07 01:00"},{"value":0.53,"datetime":"2016-12-07 02:00"},{"value":0.54,"datetime":"2016-12-07 03:00"},{"value":0.55,"datetime":"2016-12-07 04:00"},{"value":0.56,"datetime":"2016-12-07 05:00"},{"value":0.58,"datetime":"2016-12-07 06:00"},{"value":0.6,"datetime":"2016-12-07 07:00"},{"value":0.58,"datetime":"2016-12-07 08:00"},{"value":0.54,"datetime":"2016-12-07 09:00"},{"value":0.47,"datetime":"2016-12-07 10:00"}]
         * pm25 : [{"value":135,"datetime":"2016-12-05 11:00"},{"value":125,"datetime":"2016-12-05 12:00"},{"value":118,"datetime":"2016-12-05 13:00"},{"value":115,"datetime":"2016-12-05 14:00"},{"value":113,"datetime":"2016-12-05 15:00"},{"value":112,"datetime":"2016-12-05 16:00"},{"value":111,"datetime":"2016-12-05 17:00"},{"value":110,"datetime":"2016-12-05 18:00"},{"value":109,"datetime":"2016-12-05 19:00"},{"value":108,"datetime":"2016-12-05 20:00"},{"value":107,"datetime":"2016-12-05 21:00"},{"value":106,"datetime":"2016-12-05 22:00"},{"value":105,"datetime":"2016-12-05 23:00"},{"value":104,"datetime":"2016-12-06 00:00"},{"value":104,"datetime":"2016-12-06 01:00"},{"value":103,"datetime":"2016-12-06 02:00"},{"value":102,"datetime":"2016-12-06 03:00"},{"value":102,"datetime":"2016-12-06 04:00"},{"value":101,"datetime":"2016-12-06 05:00"},{"value":100,"datetime":"2016-12-06 06:00"},{"value":100,"datetime":"2016-12-06 07:00"},{"value":99,"datetime":"2016-12-06 08:00"},{"value":99,"datetime":"2016-12-06 09:00"},{"value":99,"datetime":"2016-12-06 10:00"},{"value":98,"datetime":"2016-12-06 11:00"},{"value":98,"datetime":"2016-12-06 12:00"},{"value":97,"datetime":"2016-12-06 13:00"},{"value":96,"datetime":"2016-12-06 14:00"},{"value":96,"datetime":"2016-12-06 15:00"},{"value":95,"datetime":"2016-12-06 16:00"},{"value":95,"datetime":"2016-12-06 17:00"},{"value":95,"datetime":"2016-12-06 18:00"},{"value":94,"datetime":"2016-12-06 19:00"},{"value":93,"datetime":"2016-12-06 20:00"},{"value":93,"datetime":"2016-12-06 21:00"},{"value":92,"datetime":"2016-12-06 22:00"},{"value":92,"datetime":"2016-12-06 23:00"},{"value":92,"datetime":"2016-12-07 00:00"},{"value":92,"datetime":"2016-12-07 01:00"},{"value":91,"datetime":"2016-12-07 02:00"},{"value":91,"datetime":"2016-12-07 03:00"},{"value":91,"datetime":"2016-12-07 04:00"},{"value":90,"datetime":"2016-12-07 05:00"},{"value":90,"datetime":"2016-12-07 06:00"},{"value":89,"datetime":"2016-12-07 07:00"},{"value":89,"datetime":"2016-12-07 08:00"},{"value":89,"datetime":"2016-12-07 09:00"},{"value":89,"datetime":"2016-12-07 10:00"}]
         * precipitation : [{"value":0,"datetime":"2016-12-05 11:00"},{"value":0,"datetime":"2016-12-05 12:00"},{"value":0,"datetime":"2016-12-05 13:00"},{"value":0,"datetime":"2016-12-05 14:00"},{"value":0,"datetime":"2016-12-05 15:00"},{"value":0,"datetime":"2016-12-05 16:00"},{"value":0,"datetime":"2016-12-05 17:00"},{"value":0,"datetime":"2016-12-05 18:00"},{"value":0,"datetime":"2016-12-05 19:00"},{"value":0,"datetime":"2016-12-05 20:00"},{"value":0,"datetime":"2016-12-05 21:00"},{"value":0,"datetime":"2016-12-05 22:00"},{"value":0,"datetime":"2016-12-05 23:00"},{"value":0,"datetime":"2016-12-06 00:00"},{"value":0,"datetime":"2016-12-06 01:00"},{"value":0,"datetime":"2016-12-06 02:00"},{"value":0,"datetime":"2016-12-06 03:00"},{"value":0,"datetime":"2016-12-06 04:00"},{"value":0,"datetime":"2016-12-06 05:00"},{"value":0,"datetime":"2016-12-06 06:00"},{"value":0,"datetime":"2016-12-06 07:00"},{"value":0,"datetime":"2016-12-06 08:00"},{"value":0,"datetime":"2016-12-06 09:00"},{"value":0,"datetime":"2016-12-06 10:00"},{"value":0,"datetime":"2016-12-06 11:00"},{"value":0,"datetime":"2016-12-06 12:00"},{"value":0,"datetime":"2016-12-06 13:00"},{"value":0,"datetime":"2016-12-06 14:00"},{"value":0,"datetime":"2016-12-06 15:00"},{"value":0,"datetime":"2016-12-06 16:00"},{"value":0,"datetime":"2016-12-06 17:00"},{"value":0,"datetime":"2016-12-06 18:00"},{"value":0,"datetime":"2016-12-06 19:00"},{"value":0,"datetime":"2016-12-06 20:00"},{"value":0,"datetime":"2016-12-06 21:00"},{"value":0,"datetime":"2016-12-06 22:00"},{"value":0,"datetime":"2016-12-06 23:00"},{"value":0,"datetime":"2016-12-07 00:00"},{"value":0,"datetime":"2016-12-07 01:00"},{"value":0,"datetime":"2016-12-07 02:00"},{"value":0,"datetime":"2016-12-07 03:00"},{"value":0,"datetime":"2016-12-07 04:00"},{"value":0,"datetime":"2016-12-07 05:00"},{"value":0,"datetime":"2016-12-07 06:00"},{"value":0,"datetime":"2016-12-07 07:00"},{"value":0,"datetime":"2016-12-07 08:00"},{"value":0,"datetime":"2016-12-07 09:00"},{"value":0,"datetime":"2016-12-07 10:00"}]
         * wind : [{"direction":344.02,"speed":10.37,"datetime":"2016-12-05 11:00"},{"direction":356.07,"speed":10.6,"datetime":"2016-12-05 12:00"},{"direction":13.44,"speed":11.65,"datetime":"2016-12-05 13:00"},{"direction":22.32,"speed":12.75,"datetime":"2016-12-05 14:00"},{"direction":17.98,"speed":12.21,"datetime":"2016-12-05 15:00"},{"direction":1.99,"speed":10.79,"datetime":"2016-12-05 16:00"},{"direction":338.3,"speed":10.13,"datetime":"2016-12-05 17:00"},{"direction":316.64,"speed":10.52,"datetime":"2016-12-05 18:00"},{"direction":301.43,"speed":11.24,"datetime":"2016-12-05 19:00"},{"direction":292.86,"speed":11.51,"datetime":"2016-12-05 20:00"},{"direction":290.32,"speed":10.87,"datetime":"2016-12-05 21:00"},{"direction":291.73,"speed":9.61,"datetime":"2016-12-05 22:00"},{"direction":294.76,"speed":8.28,"datetime":"2016-12-05 23:00"},{"direction":296.04,"speed":7.3,"datetime":"2016-12-06 00:00"},{"direction":293.61,"speed":6.55,"datetime":"2016-12-06 01:00"},{"direction":286.07,"speed":5.89,"datetime":"2016-12-06 02:00"},{"direction":272.27,"speed":5.39,"datetime":"2016-12-06 03:00"},{"direction":256.16,"speed":5.34,"datetime":"2016-12-06 04:00"},{"direction":244.86,"speed":5.68,"datetime":"2016-12-06 05:00"},{"direction":241.57,"speed":5.97,"datetime":"2016-12-06 06:00"},{"direction":244.25,"speed":5.96,"datetime":"2016-12-06 07:00"},{"direction":251.61,"speed":5.57,"datetime":"2016-12-06 08:00"},{"direction":264.19,"speed":4.92,"datetime":"2016-12-06 09:00"},{"direction":281.69,"speed":4.43,"datetime":"2016-12-06 10:00"},{"direction":298.47,"speed":4.39,"datetime":"2016-12-06 11:00"},{"direction":308.54,"speed":4.59,"datetime":"2016-12-06 12:00"},{"direction":315.98,"speed":4.8,"datetime":"2016-12-06 13:00"},{"direction":326.57,"speed":5.05,"datetime":"2016-12-06 14:00"},{"direction":341.98,"speed":5.68,"datetime":"2016-12-06 15:00"},{"direction":354.97,"speed":6.87,"datetime":"2016-12-06 16:00"},{"direction":1.43,"speed":8.29,"datetime":"2016-12-06 17:00"},{"direction":2.12,"speed":9.47,"datetime":"2016-12-06 18:00"},{"direction":0.61,"speed":10.25,"datetime":"2016-12-06 19:00"},{"direction":359.55,"speed":10.52,"datetime":"2016-12-06 20:00"},{"direction":0.48,"speed":10.21,"datetime":"2016-12-06 21:00"},{"direction":2.58,"speed":9.49,"datetime":"2016-12-06 22:00"},{"direction":4.24,"speed":8.61,"datetime":"2016-12-06 23:00"},{"direction":3.47,"speed":7.71,"datetime":"2016-12-07 00:00"},{"direction":359.41,"speed":6.84,"datetime":"2016-12-07 01:00"},{"direction":351.41,"speed":6.07,"datetime":"2016-12-07 02:00"},{"direction":339.48,"speed":5.53,"datetime":"2016-12-07 03:00"},{"direction":326.79,"speed":5.42,"datetime":"2016-12-07 04:00"},{"direction":318.36,"speed":5.65,"datetime":"2016-12-07 05:00"},{"direction":316.37,"speed":6.01,"datetime":"2016-12-07 06:00"},{"direction":317.68,"speed":6.3,"datetime":"2016-12-07 07:00"},{"direction":318.82,"speed":6.41,"datetime":"2016-12-07 08:00"},{"direction":317.59,"speed":6.23,"datetime":"2016-12-07 09:00"},{"direction":314.82,"speed":5.7,"datetime":"2016-12-07 10:00"}]
         * temperature : [{"value":10.96,"datetime":"2016-12-05 11:00"},{"value":12.61,"datetime":"2016-12-05 12:00"},{"value":14.14,"datetime":"2016-12-05 13:00"},{"value":15.37,"datetime":"2016-12-05 14:00"},{"value":16.11,"datetime":"2016-12-05 15:00"},{"value":16.18,"datetime":"2016-12-05 16:00"},{"value":15.41,"datetime":"2016-12-05 17:00"},{"value":13.75,"datetime":"2016-12-05 18:00"},{"value":11.77,"datetime":"2016-12-05 19:00"},{"value":10.15,"datetime":"2016-12-05 20:00"},{"value":9.39,"datetime":"2016-12-05 21:00"},{"value":9.23,"datetime":"2016-12-05 22:00"},{"value":9.2,"datetime":"2016-12-05 23:00"},{"value":8.94,"datetime":"2016-12-06 00:00"},{"value":8.55,"datetime":"2016-12-06 01:00"},{"value":8.22,"datetime":"2016-12-06 02:00"},{"value":8.07,"datetime":"2016-12-06 03:00"},{"value":7.9,"datetime":"2016-12-06 04:00"},{"value":7.44,"datetime":"2016-12-06 05:00"},{"value":6.6,"datetime":"2016-12-06 06:00"},{"value":5.98,"datetime":"2016-12-06 07:00"},{"value":6.35,"datetime":"2016-12-06 08:00"},{"value":8.22,"datetime":"2016-12-06 09:00"},{"value":10.86,"datetime":"2016-12-06 10:00"},{"value":13.29,"datetime":"2016-12-06 11:00"},{"value":14.74,"datetime":"2016-12-06 12:00"},{"value":15.4,"datetime":"2016-12-06 13:00"},{"value":15.69,"datetime":"2016-12-06 14:00"},{"value":15.89,"datetime":"2016-12-06 15:00"},{"value":15.8,"datetime":"2016-12-06 16:00"},{"value":15.08,"datetime":"2016-12-06 17:00"},{"value":13.56,"datetime":"2016-12-06 18:00"},{"value":11.7,"datetime":"2016-12-06 19:00"},{"value":10.11,"datetime":"2016-12-06 20:00"},{"value":9.26,"datetime":"2016-12-06 21:00"},{"value":8.92,"datetime":"2016-12-06 22:00"},{"value":8.71,"datetime":"2016-12-06 23:00"},{"value":8.33,"datetime":"2016-12-07 00:00"},{"value":7.86,"datetime":"2016-12-07 01:00"},{"value":7.43,"datetime":"2016-12-07 02:00"},{"value":7.14,"datetime":"2016-12-07 03:00"},{"value":6.85,"datetime":"2016-12-07 04:00"},{"value":6.39,"datetime":"2016-12-07 05:00"},{"value":5.7,"datetime":"2016-12-07 06:00"},{"value":5.27,"datetime":"2016-12-07 07:00"},{"value":5.74,"datetime":"2016-12-07 08:00"},{"value":7.51,"datetime":"2016-12-07 09:00"},{"value":10.01,"datetime":"2016-12-07 10:00"}]
         */

        private HourlyBean hourly;
        /**
         * status : ok
         * description : 未来两小时不会下雨，放心出门吧
         * probability : [0,0,0,0]
         * datasource : radar
         * precipitation_2h : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
         * precipitation : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
         */

        private MinutelyBean minutely;
        /**
         * status : ok
         * coldRisk : [{"index":"4","desc":"极易发","datetime":"2016-12-05"},{"index":"4","desc":"极易发","datetime":"2016-12-06"},{"index":"4","desc":"极易发","datetime":"2016-12-07"},{"index":"4","desc":"极易发","datetime":"2016-12-08"},{"index":"4","desc":"极易发","datetime":"2016-12-09"}]
         * temperature : [{"date":"2016-12-05","max":16.18,"avg":12.64,"min":6.88},{"date":"2016-12-06","max":15.89,"avg":10.64,"min":5.98},{"date":"2016-12-07","max":16.31,"avg":10.16,"min":5.27},{"date":"2016-12-08","max":15.74,"avg":9.51,"min":4.73},{"date":"2016-12-09","max":15.35,"avg":9.98,"min":5.62}]
         * skycon : [{"date":"2016-12-05","value":"CLEAR_DAY"},{"date":"2016-12-06","value":"CLEAR_DAY"},{"date":"2016-12-07","value":"CLEAR_DAY"},{"date":"2016-12-08","value":"CLEAR_DAY"},{"date":"2016-12-09","value":"CLEAR_DAY"}]
         * cloudrate : [{"date":"2016-12-05","max":0.67,"avg":0.19,"min":0},{"date":"2016-12-06","max":0.43,"avg":0.09,"min":0},{"date":"2016-12-07","max":0,"avg":0,"min":0},{"date":"2016-12-08","max":0.01,"avg":0,"min":0},{"date":"2016-12-09","max":0.21,"avg":0.1,"min":0}]
         * aqi : [{"date":"2016-12-05","max":271,"avg":148.69,"min":138},{"date":"2016-12-06","max":136,"avg":128.79,"min":122},{"date":"2016-12-07","max":122,"avg":117.25,"min":113},{"date":"2016-12-08","max":113,"avg":110.83,"min":108},{"date":"2016-12-09","max":108,"avg":106.92,"min":105}]
         * humidity : [{"date":"2016-12-05","max":0.97,"avg":0.49,"min":0.33},{"date":"2016-12-06","max":0.48,"avg":0.33,"min":0.25},{"date":"2016-12-07","max":0.6,"avg":0.47,"min":0.3},{"date":"2016-12-08","max":0.77,"avg":0.61,"min":0.4},{"date":"2016-12-09","max":0.92,"avg":0.74,"min":0.55}]
         * astro : [{"date":"2016-12-05","sunset":{"time":"18:01"},"sunrise":{"time":"07:46"}},{"date":"2016-12-06","sunset":{"time":"18:02"},"sunrise":{"time":"07:47"}},{"date":"2016-12-07","sunset":{"time":"18:02"},"sunrise":{"time":"07:47"}},{"date":"2016-12-08","sunset":{"time":"18:02"},"sunrise":{"time":"07:48"}},{"date":"2016-12-09","sunset":{"time":"18:02"},"sunrise":{"time":"07:49"}}]
         * ultraviolet : [{"index":"2","desc":"弱","datetime":"2016-12-05"},{"index":"4","desc":"强","datetime":"2016-12-06"},{"index":"4","desc":"强","datetime":"2016-12-07"},{"index":"4","desc":"强","datetime":"2016-12-08"},{"index":"4","desc":"强","datetime":"2016-12-09"}]
         * pm25 : [{"date":"2016-12-05","max":221,"avg":113.38,"min":105},{"date":"2016-12-06","max":104,"avg":97.79,"min":92},{"date":"2016-12-07","max":92,"avg":88.29,"min":85},{"date":"2016-12-08","max":85,"avg":83.17,"min":81},{"date":"2016-12-09","max":81,"avg":79.92,"min":78}]
         * dressing : [{"index":"5","desc":"凉爽","datetime":"2016-12-05"},{"index":"5","desc":"凉爽","datetime":"2016-12-06"},{"index":"5","desc":"凉爽","datetime":"2016-12-07"},{"index":"6","desc":"冷","datetime":"2016-12-08"},{"index":"6","desc":"冷","datetime":"2016-12-09"}]
         * carWashing : [{"index":"2","desc":"较适宜","datetime":"2016-12-05"},{"index":"2","desc":"较适宜","datetime":"2016-12-06"},{"index":"2","desc":"较适宜","datetime":"2016-12-07"},{"index":"2","desc":"较适宜","datetime":"2016-12-08"},{"index":"2","desc":"较适宜","datetime":"2016-12-09"}]
         * precipitation : [{"date":"2016-12-05","max":0,"avg":0,"min":0},{"date":"2016-12-06","max":0,"avg":0,"min":0},{"date":"2016-12-07","max":0,"avg":0,"min":0},{"date":"2016-12-08","max":0,"avg":0,"min":0},{"date":"2016-12-09","max":0,"avg":0,"min":0}]
         * wind : [{"date":"2016-12-05","max":{"direction":22.32,"speed":12.75},"avg":{"direction":347.33,"speed":9.66},"min":{"direction":356.32,"speed":6.96}},{"date":"2016-12-06","max":{"direction":359.55,"speed":10.52},"avg":{"direction":320.5,"speed":6.72},"min":{"direction":298.47,"speed":4.39}},{"date":"2016-12-07","max":{"direction":307.71,"speed":11.74},"avg":{"direction":317.07,"speed":6.18},"min":{"direction":298.63,"speed":1.47}},{"date":"2016-12-08","max":{"direction":335.64,"speed":11.59},"avg":{"direction":355.63,"speed":7.91},"min":{"direction":315.29,"speed":5.16}},{"date":"2016-12-09","max":{"direction":345.18,"speed":13.69},"avg":{"direction":352.04,"speed":8.7},"min":{"direction":334.42,"speed":5.85}}]
         */

        private DailyBean daily;
        private int primary;

        public HourlyBean getHourly() {
            return hourly;
        }

        public void setHourly(HourlyBean hourly) {
            this.hourly = hourly;
        }

        public MinutelyBean getMinutely() {
            return minutely;
        }

        public void setMinutely(MinutelyBean minutely) {
            this.minutely = minutely;
        }

        public DailyBean getDaily() {
            return daily;
        }

        public void setDaily(DailyBean daily) {
            this.daily = daily;
        }

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public static class HourlyBean {
            private String status;
            private String description;
            /**
             * value : PARTLY_CLOUDY_DAY
             * datetime : 2016-12-05 11:00
             */

            private List<SkyconBean> skycon;
            /**
             * value : 0.67
             * datetime : 2016-12-05 11:00
             */

            private List<CloudrateBean> cloudrate;
            /**
             * value : 179
             * datetime : 2016-12-05 11:00
             */

            private List<AqiBean> aqi;
            /**
             * value : 0.72
             * datetime : 2016-12-05 11:00
             */

            private List<HumidityBean> humidity;
            /**
             * value : 135
             * datetime : 2016-12-05 11:00
             */

            private List<Pm25Bean> pm25;
            /**
             * value : 0
             * datetime : 2016-12-05 11:00
             */

            private List<PrecipitationBean> precipitation;
            /**
             * direction : 344.02
             * speed : 10.37
             * datetime : 2016-12-05 11:00
             */

            private List<WindBean> wind;
            /**
             * value : 10.96
             * datetime : 2016-12-05 11:00
             */

            private List<TemperatureBean> temperature;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public List<SkyconBean> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBean> skycon) {
                this.skycon = skycon;
            }

            public List<CloudrateBean> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBean> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<AqiBean> getAqi() {
                return aqi;
            }

            public void setAqi(List<AqiBean> aqi) {
                this.aqi = aqi;
            }

            public List<HumidityBean> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBean> humidity) {
                this.humidity = humidity;
            }

            public List<Pm25Bean> getPm25() {
                return pm25;
            }

            public void setPm25(List<Pm25Bean> pm25) {
                this.pm25 = pm25;
            }

            public List<PrecipitationBean> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBean> precipitation) {
                this.precipitation = precipitation;
            }

            public List<WindBean> getWind() {
                return wind;
            }

            public void setWind(List<WindBean> wind) {
                this.wind = wind;
            }

            public List<TemperatureBean> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBean> temperature) {
                this.temperature = temperature;
            }

            public static class SkyconBean {
                private String value;
                private String datetime;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class CloudrateBean {
                private double value;
                private String datetime;

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class AqiBean {
                private double value;
                private String datetime;

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class HumidityBean {
                private double value;
                private String datetime;

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class Pm25Bean {
                private double value;
                private String datetime;

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class PrecipitationBean {
                private double value;
                private String datetime;

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class WindBean {
                private double direction;
                private double speed;
                private String datetime;

                public double getDirection() {
                    return direction;
                }

                public void setDirection(double direction) {
                    this.direction = direction;
                }

                public double getSpeed() {
                    return speed;
                }

                public void setSpeed(double speed) {
                    this.speed = speed;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class TemperatureBean {
                private double value;
                private String datetime;

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }
        }

        public static class MinutelyBean {
            private String status;
            private String description;
            private String datasource;
            private List<Double> probability;
            private List<Double> precipitation_2h;
            private List<Double> precipitation;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDatasource() {
                return datasource;
            }

            public void setDatasource(String datasource) {
                this.datasource = datasource;
            }

            public List<Double> getProbability() {
                return probability;
            }

            public void setProbability(List<Double> probability) {
                this.probability = probability;
            }

            public List<Double> getPrecipitation_2h() {
                return precipitation_2h;
            }

            public void setPrecipitation_2h(List<Double> precipitation_2h) {
                this.precipitation_2h = precipitation_2h;
            }

            public List<Double> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<Double> precipitation) {
                this.precipitation = precipitation;
            }
        }

        public static class DailyBean {
            private String status;
            /**
             * index : 4
             * desc : 极易发
             * datetime : 2016-12-05
             */

            private List<ColdRiskBean> coldRisk;
            /**
             * date : 2016-12-05
             * max : 16.18
             * avg : 12.64
             * min : 6.88
             */

            private List<TemperatureBean> temperature;
            /**
             * date : 2016-12-05
             * value : CLEAR_DAY
             */

            private List<SkyconBean> skycon;
            /**
             * date : 2016-12-05
             * max : 0.67
             * avg : 0.19
             * min : 0
             */

            private List<CloudrateBean> cloudrate;
            /**
             * date : 2016-12-05
             * max : 271
             * avg : 148.69
             * min : 138
             */

            private List<AqiBean> aqi;
            /**
             * date : 2016-12-05
             * max : 0.97
             * avg : 0.49
             * min : 0.33
             */

            private List<HumidityBean> humidity;
            /**
             * date : 2016-12-05
             * sunset : {"time":"18:01"}
             * sunrise : {"time":"07:46"}
             */

            private List<AstroBean> astro;
            /**
             * index : 2
             * desc : 弱
             * datetime : 2016-12-05
             */

            private List<UltravioletBean> ultraviolet;
            /**
             * date : 2016-12-05
             * max : 221
             * avg : 113.38
             * min : 105
             */

            private List<Pm25Bean> pm25;
            /**
             * index : 5
             * desc : 凉爽
             * datetime : 2016-12-05
             */

            private List<DressingBean> dressing;
            /**
             * index : 2
             * desc : 较适宜
             * datetime : 2016-12-05
             */

            private List<CarWashingBean> carWashing;
            /**
             * date : 2016-12-05
             * max : 0
             * avg : 0
             * min : 0
             */

            private List<PrecipitationBean> precipitation;
            /**
             * date : 2016-12-05
             * max : {"direction":22.32,"speed":12.75}
             * avg : {"direction":347.33,"speed":9.66}
             * min : {"direction":356.32,"speed":6.96}
             */

            private List<WindBean> wind;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<ColdRiskBean> getColdRisk() {
                return coldRisk;
            }

            public void setColdRisk(List<ColdRiskBean> coldRisk) {
                this.coldRisk = coldRisk;
            }

            public List<TemperatureBean> getTemperature() {
                return temperature;
            }

            public void setTemperature(List<TemperatureBean> temperature) {
                this.temperature = temperature;
            }

            public List<SkyconBean> getSkycon() {
                return skycon;
            }

            public void setSkycon(List<SkyconBean> skycon) {
                this.skycon = skycon;
            }

            public List<CloudrateBean> getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(List<CloudrateBean> cloudrate) {
                this.cloudrate = cloudrate;
            }

            public List<AqiBean> getAqi() {
                return aqi;
            }

            public void setAqi(List<AqiBean> aqi) {
                this.aqi = aqi;
            }

            public List<HumidityBean> getHumidity() {
                return humidity;
            }

            public void setHumidity(List<HumidityBean> humidity) {
                this.humidity = humidity;
            }

            public List<AstroBean> getAstro() {
                return astro;
            }

            public void setAstro(List<AstroBean> astro) {
                this.astro = astro;
            }

            public List<UltravioletBean> getUltraviolet() {
                return ultraviolet;
            }

            public void setUltraviolet(List<UltravioletBean> ultraviolet) {
                this.ultraviolet = ultraviolet;
            }

            public List<Pm25Bean> getPm25() {
                return pm25;
            }

            public void setPm25(List<Pm25Bean> pm25) {
                this.pm25 = pm25;
            }

            public List<DressingBean> getDressing() {
                return dressing;
            }

            public void setDressing(List<DressingBean> dressing) {
                this.dressing = dressing;
            }

            public List<CarWashingBean> getCarWashing() {
                return carWashing;
            }

            public void setCarWashing(List<CarWashingBean> carWashing) {
                this.carWashing = carWashing;
            }

            public List<PrecipitationBean> getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(List<PrecipitationBean> precipitation) {
                this.precipitation = precipitation;
            }

            public List<WindBean> getWind() {
                return wind;
            }

            public void setWind(List<WindBean> wind) {
                this.wind = wind;
            }

            public static class ColdRiskBean {
                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class TemperatureBean {
                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class SkyconBean {
                private String date;
                private String value;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class CloudrateBean {
                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class AqiBean {
                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class HumidityBean {
                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class AstroBean {
                private String date;
                /**
                 * time : 18:01
                 */

                private SunsetBean sunset;
                /**
                 * time : 07:46
                 */

                private SunriseBean sunrise;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public SunsetBean getSunset() {
                    return sunset;
                }

                public void setSunset(SunsetBean sunset) {
                    this.sunset = sunset;
                }

                public SunriseBean getSunrise() {
                    return sunrise;
                }

                public void setSunrise(SunriseBean sunrise) {
                    this.sunrise = sunrise;
                }

                public static class SunsetBean {
                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }

                public static class SunriseBean {
                    private String time;

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }
            }

            public static class UltravioletBean {
                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class Pm25Bean {
                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class DressingBean {
                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class CarWashingBean {
                private String index;
                private String desc;
                private String datetime;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getDatetime() {
                    return datetime;
                }

                public void setDatetime(String datetime) {
                    this.datetime = datetime;
                }
            }

            public static class PrecipitationBean {
                private String date;
                private double max;
                private double avg;
                private double min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getMax() {
                    return max;
                }

                public void setMax(double max) {
                    this.max = max;
                }

                public double getAvg() {
                    return avg;
                }

                public void setAvg(double avg) {
                    this.avg = avg;
                }

                public double getMin() {
                    return min;
                }

                public void setMin(double min) {
                    this.min = min;
                }
            }

            public static class WindBean {
                private String date;
                /**
                 * direction : 22.32
                 * speed : 12.75
                 */

                private MaxBean max;
                /**
                 * direction : 347.33
                 * speed : 9.66
                 */

                private AvgBean avg;
                /**
                 * direction : 356.32
                 * speed : 6.96
                 */

                private MinBean min;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public MaxBean getMax() {
                    return max;
                }

                public void setMax(MaxBean max) {
                    this.max = max;
                }

                public AvgBean getAvg() {
                    return avg;
                }

                public void setAvg(AvgBean avg) {
                    this.avg = avg;
                }

                public MinBean getMin() {
                    return min;
                }

                public void setMin(MinBean min) {
                    this.min = min;
                }

                public static class MaxBean {
                    private double direction;
                    private double speed;

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }
                }

                public static class AvgBean {
                    private double direction;
                    private double speed;

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }
                }

                public static class MinBean {
                    private double direction;
                    private double speed;

                    public double getDirection() {
                        return direction;
                    }

                    public void setDirection(double direction) {
                        this.direction = direction;
                    }

                    public double getSpeed() {
                        return speed;
                    }

                    public void setSpeed(double speed) {
                        this.speed = speed;
                    }
                }
            }
        }
    }
}