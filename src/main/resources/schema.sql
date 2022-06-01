CREATE TABLE `csv_to_database`.`register_numbering`
(
    `id`                 INT          NOT NULL AUTO_INCREMENT,
    `abc_def`            INT          NOT NULL,
    `range_from`         INT          NOT NULL,
    `range_to`           INT          NOT NULL,
    `numbering_capacity` INT          NOT NULL,
    `operator`           VARCHAR(240) NOT NULL,
    `region`             VARCHAR(240) NOT NULL,
    `tin`                INT          NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `csv_to_database`.`register_numbering_with_city`
(
    `id`                 INT          NOT NULL AUTO_INCREMENT,
    `abc_def`            INT          NOT NULL,
    `range_from`         INT          NOT NULL,
    `range_to`           INT          NOT NULL,
    `numbering_capacity` INT          NOT NULL,
    `operator`           VARCHAR(240) NOT NULL,
    `region_1`             VARCHAR(240),
    `region_2`               VARCHAR(240),
    `region_3`           VARCHAR(240),
    `tin`                INT          NOT NULL,
    PRIMARY KEY (`id`)
);
