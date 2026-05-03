hotel
    PK          id
    vchar       name
    vchar       description
    location    location
    
room
    PK1         id          - part of pk
    FPK         hotel_id    - part of pk

    vchar       description
    int         price_per_night
    int         max_occupants

booking
    PK1         id          - part of pk
    FPK         hotel_id    - part of pk
    FPK         room_id     - part of pk

    FPK         guest
    date        start_date
    date        end_date 
    bool        confirmed

guest
    PK          id
    vchar       first_name
    vchar       last_name
    vchar       email
