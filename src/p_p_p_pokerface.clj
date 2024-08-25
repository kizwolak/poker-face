(ns p-p-p-pokerface)

(def high-card-values {\T 10, \J 11, \Q 12, \K 13, \A 14})

(defn rank
  "Get rank as int"
  [card]
  (let [[rank _] card]
    (if (Character/isDigit rank)
      (Integer/valueOf (str rank))
      (get high-card-values rank))))

(defn suit [card]
  (let [[_ suit] card]
    (str suit)))

(defn pair? [hand]
  (contains? (set (vals (frequencies (map rank hand)))) 2))

(defn three-of-a-kind? [hand]
  (contains? (set (vals (frequencies (map rank hand)))) 3))

(defn four-of-a-kind? [hand]
  (contains? (set (vals (frequencies (map rank hand)))) 4))

(defn flush? [hand]
  (contains? (set (vals (frequencies (map suit hand))))  5))

(defn full-house? [hand]
  (and (contains? (set (vals (frequencies (map rank hand)))) 2)
       (contains? (set (vals (frequencies (map rank hand)))) 3)))

(defn two-pairs? [hand]
  (= (count (filter (fn [x]
                   (= x 2)) (vals (frequencies (map rank hand))))) 2))

(defn straight? [hand]
  nil)

(defn straight-flush? [hand]
  nil)

(defn value [hand]
  nil)
