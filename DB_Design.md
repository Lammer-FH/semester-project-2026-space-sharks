hotel
    PK          id
    varchar     name
    varchar     description
    varchar     location
    varchar     image_url


room
    PK          id
    FK          hotel_id        -> hotel.id
    varchar     name
    varchar     description
    int         price_per_night
    int         max_occupants
    varchar     image_url


guest
    PK          id
    varchar     first_name
    varchar     last_name
    varchar     email


booking
    PK          id
    FK          room_id         -> room.id
    FK          guest_id        -> guest.id
    date        start_date
    date        end_date
    bool        breakfast
    bool        confirmed
    timestamp   created_at


feature
    PK          id
    varchar     name
    varchar     icon


room_feature
    PK, FK      room_id         -> room.id
    PK, FK      feature_id      -> feature.id

relationships
    hotel        1  ---  n    room
    room         1  ---  n    booking
    guest        1  ---  n    booking
    room         n  ---  m    feature   via room_feature
