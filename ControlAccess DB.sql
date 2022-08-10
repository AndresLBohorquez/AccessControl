-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema accessdb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema accessdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `accessdb` ;

-- -----------------------------------------------------
-- Schema accessdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `accessdb` DEFAULT CHARACTER SET utf8 ;
USE `accessdb` ;

-- -----------------------------------------------------
-- Table `accessdb`.`area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accessdb`.`area` (
  `idarea` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_area` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idarea`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `accessdb`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accessdb`.`estado` (
  `idestado` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_estado` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idestado`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `accessdb`.`paisempleo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accessdb`.`paisempleo` (
  `idpais` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_pais` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idpais`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `accessdb`.`tipo_identificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accessdb`.`tipo_identificacion` (
  `idtipo_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_id` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`idtipo_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `accessdb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `accessdb`.`usuario` (
  `idusuario` INT(11) NOT NULL AUTO_INCREMENT,
  `primer_apellido` VARCHAR(20) NOT NULL,
  `segundo_apellido` VARCHAR(20) NOT NULL,
  `primer_nombre` VARCHAR(20) NOT NULL,
  `otros_nombres` VARCHAR(50) NULL DEFAULT NULL,
  `paisEmpleo_idpais` INT(11) NOT NULL,
  `tipo_identificacion_idtipo_id` INT(11) NOT NULL,
  `numero_identificacion` VARCHAR(20) NOT NULL,
  `correo_electronico` VARCHAR(300) NULL DEFAULT NULL,
  `fecha_ingreso` VARCHAR(15) NULL DEFAULT NULL,
  `area_idarea` INT(11) NOT NULL,
  `estado_idestado` INT(11) NOT NULL DEFAULT '0',
  `fecha_registro` VARCHAR(20) NULL DEFAULT NULL,
  `fecha_modificacion` VARCHAR(20) NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `fk_usuario_estado_idx` (`estado_idestado` ASC) ,
  INDEX `fk_usuario_area1_idx` (`area_idarea` ASC) ,
  INDEX `fk_usuario_paisEmpleo1_idx` (`paisEmpleo_idpais` ASC) ,
  INDEX `fk_usuario_tipo_identificacion1_idx` (`tipo_identificacion_idtipo_id` ASC) ,
  CONSTRAINT `fk_usuario_area1`
    FOREIGN KEY (`area_idarea`)
    REFERENCES `accessdb`.`area` (`idarea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_estado`
    FOREIGN KEY (`estado_idestado`)
    REFERENCES `accessdb`.`estado` (`idestado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_paisEmpleo1`
    FOREIGN KEY (`paisEmpleo_idpais`)
    REFERENCES `accessdb`.`paisempleo` (`idpais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_tipo_identificacion1`
    FOREIGN KEY (`tipo_identificacion_idtipo_id`)
    REFERENCES `accessdb`.`tipo_identificacion` (`idtipo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `accessdb`.`area`
-- -----------------------------------------------------
START TRANSACTION;
USE `accessdb`;
INSERT INTO `accessdb`.`area` (`idarea`, `nombre_area`) VALUES (1, 'Administración');
INSERT INTO `accessdb`.`area` (`idarea`, `nombre_area`) VALUES (2, 'Financiera');
INSERT INTO `accessdb`.`area` (`idarea`, `nombre_area`) VALUES (3, 'Compras');
INSERT INTO `accessdb`.`area` (`idarea`, `nombre_area`) VALUES (4, 'Infraestructura');
INSERT INTO `accessdb`.`area` (`idarea`, `nombre_area`) VALUES (5, 'Operación');
INSERT INTO `accessdb`.`area` (`idarea`, `nombre_area`) VALUES (6, 'Talento Humano');
INSERT INTO `accessdb`.`area` (`idarea`, `nombre_area`) VALUES (7, 'Servicios Varios');

COMMIT;


-- -----------------------------------------------------
-- Data for table `accessdb`.`estado`
-- -----------------------------------------------------
START TRANSACTION;
USE `accessdb`;
INSERT INTO `accessdb`.`estado` (`idestado`, `nombre_estado`) VALUES (1, 'Activo');
INSERT INTO `accessdb`.`estado` (`idestado`, `nombre_estado`) VALUES (2, 'Inactivo');

COMMIT;


-- -----------------------------------------------------
-- Data for table `accessdb`.`paisempleo`
-- -----------------------------------------------------
START TRANSACTION;
USE `accessdb`;
INSERT INTO `accessdb`.`paisempleo` (`idpais`, `nombre_pais`) VALUES (1, 'Colombia');
INSERT INTO `accessdb`.`paisempleo` (`idpais`, `nombre_pais`) VALUES (2, 'Estados Unidos');

COMMIT;


-- -----------------------------------------------------
-- Data for table `accessdb`.`tipo_identificacion`
-- -----------------------------------------------------
START TRANSACTION;
USE `accessdb`;
INSERT INTO `accessdb`.`tipo_identificacion` (`idtipo_id`, `nombre_id`) VALUES (1, 'Cédula Ciudadanía');
INSERT INTO `accessdb`.`tipo_identificacion` (`idtipo_id`, `nombre_id`) VALUES (2, 'Cédula Extranjería');
INSERT INTO `accessdb`.`tipo_identificacion` (`idtipo_id`, `nombre_id`) VALUES (3, 'Pasaporte');
INSERT INTO `accessdb`.`tipo_identificacion` (`idtipo_id`, `nombre_id`) VALUES (4, 'Permiso Especial');

COMMIT;

-- -----------------------------------------------------
-- Data for table `accessdb`.`usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `accessdb`;
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('15', 'ALINADO', 'ASTURIAS', 'CARLOS', 'CRISPIN', '2', '2', '54211', 'carlos.alinado@cidenet.com.us', '12/07/2022', '7', '1', '22/07/2022 19:09:58');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('16', 'NORIEGA', 'MORALES', 'CESAR', 'AUGUSTO', '2', '1', '49973', 'cesar.noriega@cidenet.com.us', '22/07/2022', '3', '1', '16/07/2022 13:48:49');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('17', 'REVOLORIO', 'QUEVEDO', 'HECTOR', 'LEONIDAS', '2', '1', '98655', 'hector.revolorio@cidenet.com.us', '04/07/2022', '1', '1', '22/07/2022 16:25:23');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('18', 'LOPEZ', 'VILLACORTA', 'HUGO', 'LEONEL', '2', '4', '16560', 'hugo.lopez@cidenet.com.us', '08/07/2022', '3', '1', '27/06/2022 14:56:18');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('19', 'SOTO', 'JUAREZ', 'MARCO', 'TULIO', '2', '3', '36418', 'marco.soto@cidenet.com.us', '07/07/2022', '7', '1', '26/07/2022 20:53:55');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('20', 'ALEMAN', 'GALINDO', 'MARIO', 'ANIBAL', '1', '4', '66278', 'mario.aleman@cidenet.com.co', '18/07/2022', '3', '1', '27/06/2022 16:30:56');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('21', 'CALDERON', 'MULLER', 'NANCY', 'BEATRIZ', '2', '3', '25751', 'nancy.calderon@cidenet.com.us', '10/07/2022', '2', '1', '19/07/2022 16:16:19');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('22', 'CARRERA', 'CHICAS', 'RAFAEL', 'ARNULFO', '2', '2', '64288', 'rafael.carrera@cidenet.com.us', '13/07/2022', '4', '1', '23/07/2022 12:40:20');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('23', 'SALAZAR', 'BARRIOS', 'RONY', 'DAVID', '2', '2', '31062', 'rony.salazar@cidenet.com.us', '11/07/2022', '2', '1', '16/07/2022 13:52:20');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('24', 'LOPEZ', 'LOPEZ', 'SANTOS', 'MARGARITA', '1', '1', '39138', 'santos.lopez@cidenet.com.co', '05/07/2022', '6', '1', '17/07/2022 19:29:57');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('25', 'PEREIRA', 'PEREZ', 'ABDUL', 'AMIBAEL', '1', '3', '78917', 'abdul.pereira@cidenet.com.co', '22/07/2022', '4', '1', '19/07/2022 18:56:46');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('26', 'ALDANA', 'TECUN', 'ABEL', 'ISAIAS', '1', '2', '89241', 'abel.aldana@cidenet.com.co', '07/07/2022', '1', '1', '25/07/2022 15:59:42');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('27', 'GRAMAJO', 'SAGASTUME', 'ADELA', 'BEATRIZ', '1', '3', '66143', 'adela.gramajo@cidenet.com.co', '11/07/2022', '7', '1', '18/07/2022 22:11:19');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('28', 'ARRECIS', 'CONCUAN', 'ADOLFO', 'ANTONIO', '2', '4', '22536', 'adolfo.arrecis@cidenet.com.us', '08/07/2022', '7', '1', '27/06/2022 12:59:39');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('29', 'ALVAREZ', 'ROSALES', 'ADOLFO', 'ORLANDO', '1', '1', '85143', 'adolfo.alvarez@cidenet.com.co', '11/07/2022', '7', '1', '24/07/2022 12:22:57');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('30', 'PEREZ', 'ESTRADA', 'ALEJANDRO', 'RIVERA', '2', '4', '74807', 'alejandro.perez@cidenet.com.us', '14/07/2022', '5', '1', '16/07/2022 12:10:49');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('31', 'OVALLE', 'GARCIA', 'ALEJANDRO', 'PEREZ', '2', '3', '54529', 'alejandro.ovalle@cidenet.com.us', '11/07/2022', '6', '1', '18/07/2022 17:19:25');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('32', 'CHAVEZ', 'OCHOA', 'AMALIA', 'CHA', '1', '2', '34311', 'amalia.chavez@cidenet.com.co', '01/07/2022', '4', '1', '18/07/2022 21:22:48');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('33', 'OSCAL', 'PAZ', 'AMERICA', 'NOEMI', '1', '2', '63302', 'america.oscal@cidenet.com.co', '28/06/2022', '7', '1', '21/07/2022 23:22:42');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('34', 'SAMAYOA', 'EGUIZABAL', 'AMILCAR', 'AUGUSTO', '2', '1', '95383', 'amilcar.samayoa@cidenet.com.us', '09/07/2022', '3', '1', '16/07/2022 13:10:59');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('35', 'ARMIRA', 'CARRETO', 'ANA', 'FRANCISCA', '1', '4', '24430', 'ana.armira@cidenet.com.co', '19/07/2022', '5', '1', '21/07/2022 13:19:09');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('36', 'LEIVA', 'GARCIA', 'ANA', 'LUCIA', '2', '1', '35912', 'ana.leiva@cidenet.com.us', '07/07/2022', '4', '1', '23/07/2022 17:05:10');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('37', 'GOMEZ', 'HERNANDEZ', 'ANDRES', 'NOE', '1', '3', '94305', 'andres.gomez@cidenet.com.co', '19/07/2022', '5', '2', '18/07/2022 10:48:43');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('38', 'SOTO', 'ARIAS', 'ANGELINO', 'LOPEZ', '2', '1', '38458', 'angelino.soto@cidenet.com.us', '30/06/2022', '7', '2', '23/07/2022 14:20:14');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('39', 'ESTRADA', 'RODRIGUEZ', 'BYRON', 'AROLDO', '2', '4', '70637', 'byron.estrada@cidenet.com.us', '14/07/2022', '7', '2', '23/07/2022 19:49:40');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('40', 'ACOSTA', 'RUANO', 'CARLOS', 'HORACIO', '2', '4', '19042', 'carlos.acosta@cidenet.com.us', '12/07/2022', '1', '2', '19/07/2022 19:07:21');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('41', 'ARIAS', 'GOMEZ', 'CARMEN', 'ENRIQUE', '1', '2', '94638', 'carmen.arias@cidenet.com.co', '11/07/2022', '4', '1', '16/07/2022 21:32:10');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('42', 'LOPEZ', 'BATRES', 'CATALINO', 'CHINCHILLA', '1', '1', '34144', 'catalino.lopez@cidenet.com.co', '05/07/2022', '6', '1', '25/07/2022 15:30:26');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('43', 'RANGEL', 'PEREZ', 'CECILIA', 'ISABEL', '1', '4', '52170', 'cecilia.rangel@cidenet.com.co', '05/07/2022', '7', '1', '19/07/2022 15:57:51');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('44', 'ASTURIAS', 'PIOX', 'CEFERINA', 'ALINADO', '2', '4', '34393', 'ceferina.asturias@cidenet.com.us', '25/07/2022', '2', '1', '25/07/2022 12:10:38');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('45', 'AMBROSIO', 'ROSALES', 'CESAR', 'ANTONIO', '1', '3', '54037', 'cesar.ambrosio@cidenet.com.co', '27/06/2022', '1', '1', '25/07/2022 12:35:11');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('46', 'VALENZUELA', 'ALFARO', 'CESAR', 'AUGUSTO', '2', '4', '31379', 'cesar.valenzuela@cidenet.com.us', '30/06/2022', '3', '1', '27/06/2022 12:57:08');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('47', 'GONZALEZ', 'IXCOLIN', 'CESAR', 'ENRIQUE', '1', '3', '93267', 'cesar.gonzalez@cidenet.com.co', '21/07/2022', '1', '1', '26/07/2022 16:36:17');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('48', 'PIOX', 'CABALLEROS', 'CINTHIA', 'VANEZA', '1', '1', '85578', 'cinthia.piox@cidenet.com.co', '14/07/2022', '3', '1', '20/07/2022 12:41:27');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('49', 'MENDOZA', 'FRANCISCO', 'CLARA', 'EVERILDA', '2', '4', '33158', 'clara.mendoza@cidenet.com.us', '13/07/2022', '6', '1', '25/07/2022 17:30:43');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('50', 'REYNOSO', 'TECUN', 'CLAUDIA', 'PATRICIA', '1', '2', '65800', 'claudia.reynoso@cidenet.com.co', '01/07/2022', '2', '1', '18/07/2022 20:26:29');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('51', 'CHAJON', 'CHAJON', 'CLODOVEO', 'NAJERA', '1', '4', '32096', 'clodoveo.chajon@cidenet.com.co', '07/07/2022', '4', '1', '24/07/2022 22:33:28');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('52', 'PEREZ', 'GUEVARA', 'CRISTIAN', 'YOVANI', '1', '4', '53612', 'cristian.perez@cidenet.com.co', '08/07/2022', '4', '1', '24/07/2022 16:39:34');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('53', 'ARIAS', 'ALVAREZ', 'DANILO', 'SAMUEL', '1', '3', '10909', 'danilo.arias@cidenet.com.co', '06/07/2022', '6', '1', '23/07/2022 14:24:29');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('54', 'BATRES', 'ESTRADA', 'DANTE', 'FLAMINIO', '2', '4', '54432', 'dante.batres@cidenet.com.us', '07/07/2022', '3', '1', '18/07/2022 18:18:47');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('55', 'TORRES', 'GARCIA', 'DELIA', 'JOHANA', '2', '4', '75956', 'delia.torres@cidenet.com.us', '17/07/2022', '3', '1', '24/07/2022 14:24:55');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('56', 'REYES', 'OCHOA', 'DENNIS', 'ABRAHAM', '1', '3', '60273', 'dennis.reyes@cidenet.com.co', '21/07/2022', '1', '1', '24/07/2022 22:39:22');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('57', 'GARCIA', 'HERRERA', 'DOMINGO', 'COBO', '1', '1', '39640', 'domingo.garcia@cidenet.com.co', '25/07/2022', '6', '1', '18/07/2022 11:10:26');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('58', 'SANCHEZ', 'LOPEZ', 'DORA', 'AMANDA', '1', '3', '30294', 'dora.sanchez@cidenet.com.co', '02/07/2022', '6', '1', '23/07/2022 13:07:09');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('59', 'GIL', 'CUYUN', 'DORA', 'ANDREINA', '2', '2', '65628', 'dora.gil@cidenet.com.us', '19/07/2022', '5', '1', '15/07/2022 19:22:30');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('60', 'FLORES', 'SOLARES', 'EDGAR', 'MARDOQUEO', '1', '3', '44735', 'edgar.flores@cidenet.com.co', '23/07/2022', '7', '1', '21/07/2022 20:52:55');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('61', 'EQUITE', 'FUENTES', 'EDGAR', 'ROLANDO', '1', '1', '57618', 'edgar.equite@cidenet.com.co', '30/06/2022', '1', '1', '18/07/2022 12:27:58');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('62', 'MAZARIEGOS', 'GARCIA', 'EDMUNDO', 'ANTONIO', '2', '4', '20643', 'edmundo.mazariegos@cidenet.com.us', '30/06/2022', '7', '1', '20/07/2022 18:55:27');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('63', 'HERRERA', 'ESCOBAR', 'EDNA', 'INDIRA', '1', '2', '21870', 'edna.herrera@cidenet.com.co', '09/07/2022', '6', '1', '18/07/2022 13:19:28');
INSERT INTO `accessdb`.`usuario` (`idusuario`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `otros_nombres`, `paisEmpleo_idpais`, `tipo_identificacion_idtipo_id`, `numero_identificacion`, `correo_electronico`, `fecha_ingreso`, `area_idarea`, `estado_idestado`, `fecha_registro`) VALUES ('64', 'ORELLANA', 'ORTIZ', 'EDVIN', 'FRANCISCO', '1', '4', '15945', 'edvin.orellana@cidenet.com.co', '20/07/2022', '1', '1', '16/07/2022 19:31:14');
COMMIT;