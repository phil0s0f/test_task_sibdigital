CREATE TABLE sort_result
(
    id        serial4   NOT NULL,
    sort_date timestamp NOT NULL,
    CONSTRAINT sort_result_pk PRIMARY KEY (id)
);

CREATE TABLE sorted_element
(
    value          int8    NOT NULL,
    index_number   int8    NOT NULL,
    element_id     serial4 NOT NULL,
    sort_result_id int8    NOT NULL,
    CONSTRAINT sorted_element_pk PRIMARY KEY (element_id)
);

ALTER TABLE sorted_element
    ADD CONSTRAINT sorted_element_sort_result_fk FOREIGN KEY (sort_result_id) REFERENCES sort_result (id) ON DELETE CASCADE ON UPDATE CASCADE;