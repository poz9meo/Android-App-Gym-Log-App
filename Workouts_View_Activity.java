package com.example.obi.gymactivitylog;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Workouts_View_Activity extends Activity {

    List<String> Activityname = new ArrayList<String>();
    List<Integer> imageID = new ArrayList<Integer>();
    List<String> Weight = new ArrayList<String>();
    List<String> Reps = new ArrayList<String>();
    int Group_Clicked = 0;

    String[] Workouts_Selection =
            {
                    "Chests", "Abs", "Ankle",
                    "Biceps", "Calves", "Forearms",
                    "Glutes/Hip Flexors", "Hamstrings",
                    "Knees", "Lower Back", "Middle Back/Lats",
                    "Neck & Upper Traps", "Obliques", "Quadriceps",
                    "Shoulders", "Spine", "Triceps",
                    "Upper Back & Lower Traps", "Wrists", "Cardio", "Exercise Break",

            };

    String[] Chest = {	"Chest Press",	"Barbell Chest Overhead Extensions",	"Barbell Push-ups",	"Bosu Ball Dumbbell Flies",	"Bosu Ball Chest Dumbbell Press",	"Bosu Ball Push-ups",	"Seated Machine Flyes",	"Cardio – Swimming",	"Clamshells – Clams",	"Decline Barbell Bench Press",	"Decline Dumbbell Bench Press",	"Decline Dumbbell Flyes",	"Decline Push-ups",	"Dumbbell Flat Bench Press",	"Dumbbell Floor Chest Press",	"Dumbbell Pullovers",	"Dynamic Clap Push-ups",	"Bench Dumbbell Flyes",	"Chest Opener Stretch",	"Gymnastic Ring Dips",	"Seated Chest Press",	"Dive Bombers",	"Incline Barbell Bench Chest Press",	"Incline Bench Dumbbell Flyes",	"Incline Close-grip Bench Press",	"Incline Dumbbell Bench Chest Press",	"Incline Push-ups",	"Landmine Press",	"Crossover Chest Flyes",	"Ball Chest Pass",	"Ball Push-Ups",	"Ball Rotational Passes",	"Medicine Ball Slams",	"Knee Push-ups",	"Muscle Ups",	"Push-ups",	"Resistance Band Chest Press",	"Resistance Band Push-ups",	"Slam",	"Single Arm Chest Press",	"Singel Arm Medicine Ball Push-ups",	"Bench Chest Press",	"Machine Shoulder Press",	"Spiderman Push-ups",	"Exercise Ball Dumbbell Chest Flyes",	"Exercise Ball Dumbbell Chest Press",	"Exercise Ball Push-ups",	"Staggered Hand Push-ups",	"Standing Cable Chest Press",	"Standing Flyes",	"Water Break",	"Static Pushup Hold",	"TRX Supension Straps Push-ups",	"TRX Straps Chest Press",	"Turkish Get Ups",	"Underhand Grip Barbell Bench Press",	"Standing Press Ups",	"Reverse Butterfly Stretch",	"Wide Push-ups"};
    String[] Abs = {"Ab Crunch Machine", "Kneeling Roll Extensions", "Agility Ladder Drills", "Double Arm Slams", "Rope Double Waves", "Rope Jumping Jacks", "Side-to-Side Swings", "Battle Rope Snakes", "Squatting Alternating Waves", "Bear Crawls", "Bench Flutter Kicks", "Cross-body Crunches", "Alternating Reach & Kickbacks", "Bosu Ball Dumbbell Flies", "Bosu Ball Knee Tucks", "Bosu Ball Mountain Climbers", "Bosu Ball Plank", "Bosu Ball Plank Leg Lifts", "Bosu Ball Push-ups", "Bosu Ball V-ups", "Squat Thrusts", "Cable Core Rotation", "Hip Raises", "Clamshells – Clams", "Old Horse Stretch", "Crunches", "Dead Bug", "Decline Bench Sit-ups", "Double Crunches", "Double Side Jackknifes", "Dumbbell Weighted Leg Pull-Ins", "Flutter Kicks", "Ring L-Holds", "Hanging Knee Raises", "Hanging Leg Raises", "Leg Raises to Bar", "Hanging Windshield Wipers", "Jog on the Spot", "Dive Bombers", "Body Rock Hold", "Walkouts", "Toe Touches", "Kettlebell Around the Worlds", "Kettlebell Deadlifts", "Kettlebell Windmills", "Knee Plank", "Kneeling Cable Crunches", "Pull-In Knee-ups", "Lying Leg Raise", "Ball Chest Pass", "Ball Rotational Passes", "Medicine Ball Slams", "Ball V-Ups", "Ball Wall Throw", "Alternating Knee-ins", "Oblique Iso Hold", "Plank", "Plan Jacks - Extended Leg", "Plank Knee to Elbow", "Plank Leg Lifts", "Walking Plank Up-Downs", "Reverse Bench Crunches", "Reverse Crunch", "V-Sit Twists", "Scarecrows", "Flat Bench Knee-ups", "Seated Vacuum", "Shadow Boxing", "Slam", "Side Plank Leg Raises", "Sit-ups", "Machine Shoulder Press", "Snap Jumps", "Exercise Ball Ab Pike Press", "Swiss Ball Crunch", "Exercise Ball Dumbbell Chest Flyes", "Exercise Ball Knee Tuck to Chest", "Exercise Ball Rollout", "Staggered Hand Push-ups", "Standing Cross-body Crunches", "Standing Kettlebell Raises", "Water Break", "Standing Strap Ab Rollout", "Static Pushup Hold", "Swiss Ball Hand Off / V-Pass", "Swiss Ball Leg Lifts", "Swiss Ball Plank", "TRX Strap Mountain Climbers", "TRX Supension Straps Push-ups", "TRX Straps Saw Pikes", "Upright Cable Wood Chops", "Soldier March", "Weighted Mason Twists", "Windshield Wipers"};
    String[] Ankle = {"Clamshells – Clams", "Machine Shoulder Press", "Water Break"};
    String[] Biceps = {"Standing Biceps Curls", "Barbell Drag Bicep Curls", "Rope Reverse Lunges", "Side-to-Side Swings", "Behind Back Standing Biceps Curls", "Bosu Ball Burpees", "Boxing with a Punching Bag", "Cable Hammer Bicep Curls", "Clamshells – Clams", "Biceps Curl to Shoulder Press", "Swiss Ball Bicep Curls", "Bar Preacher Curls", "Concentration Curls", "One Arm Dumbbell Preacher Curl", "Overhead Cable Crucifix Curls", "Resistance Band Bicep Curls", "Curl Bar Curls", "Bench Dumbbell Curls", "Dumbbell Bicep Curls", "Dumbbell Concentration Curls", "Shadow Boxing", "Machine Shoulder Press", "Standing Bicep Cable Curls", "Standing Dumbbell Bicep Curls", "Standing Bicep Hammer Curls", "Water Break", "Reverse Barbell Curls", "Static Bicep Curls", "TRX Strap Bicep Curls"};
    String[] Calves = {"Twisting Jump Squats", "Agility Ladder Drills", "Barbell Overhead Squats", "Barbell Split Squats", "Rope Jumping Jacks", "Calf Raises", "Cardio – Walking", "Cardio – Sprints", "Cardio – Riding", "Clamshells – Clams", "Calves Stretch", "Raises", "Machine Calf Raises", "Ragdoll Toe Touches", "Skipping", "Seal Jacks", "Seated Calf Raises", "Machine Shoulder Press", "Standing Barbell Calf Raises", "Standing Dumbbell Calf Raises", "Water Break", "Straight Leg Calf Stretch"};
    String[] Forearms = {"Clamshells – Clams", "Dumbbell Bicep Reverse Curls", "Carry", "Down Wrist Curls", "Up Wrist Curls", "Machine Shoulder Press", "Water Break"};
    String[] Glutes_Hip_Flexors = {"Adduction Inner Thigh Machine", "Agility Ladder Drills", "Barbell Box Squats", "Barbell Hip Thrusts", "Barbell Kneeling Squats", "Barbell Snatch", "Barbell Squats", "Barbell Step-ups", "Rope Reverse Lunges", "Lateral Lunges", "Squats", "Bosu Ball Plank Leg Lifts", "Bosu Ball Single Leg Raises", "Bosu Ball Squats", "Squat Thrusts", "Butterfly Stretch", "Cable Hip Extensions", "Cardio – Crosstrainer Machine", "Cardio – Sprints", "Cardio – Stairmaster", "Cardio – Swimming", "Chair Squats", "Clamshells – Clams", "Crab Walks", "Donkey Kicks", "Dumbbell Deadlifts", "Dumbbell Lunges", "Dumbbell Squat Clean and Press", "Adductor Knee Raises", "Butt Stretch", "Outer Thighs Stretch", "Leg Hip Swings", "Front Barbell Squats", "Gluteal Stretch", "Groiners", "High Box Jumps", "Hindu Squats", "Hip Circles", "Bridges", "Walkouts", "Jump Squats", "Star Jumps", "Kettlebell Around the Worlds", "Kettlebell Squats", "Hip Flexor Stretch", "Machine Squat Press", "Lunge - Front Kicks", "Lunge Twists", "Lunge with Bicep Hammer Curls", "Lying Side Leg Lift", "Machine Hack Squats", "Alternating Knee-ins", "One Arm Kettlebell Push and Press", "One Arm Kettlebell Snatch", "Piriformis Stretch", "Single-Leg Extended Arm Squats", "Plan Jacks - Extended Leg", "Plank Knee to Elbow", "Sandbag Good Mornings", "Sandbag Lunges", "Sandbag Squats", "Resistance Band Clam Shells", "Resistance Band Deadlifts", "Resistance Band Glute Bridges", "Resistance Band Glute Kickbacks", "Resistance Band Lying Leg Extensions", "Resistance Band Side Steps", "Skipping", "Roundhouse Kicks", "Lunge Stretch", "Hip Swings", "Side Plank Leg Raises", "Single Leg Bodyweight Squats", "Hip Extension with Leg Lift", "Singe Leg Curls", "Sissy Squats", "Sled Push", "Machine Shoulder Press", "Snap Jumps", "Exercise Ball Ab Pike Press", "Standing Adduction Stretch", "Standing Knee Hugs", "Standing Long Jumps", "Water Break", "Plié Dumbbell Squats", "Sumo Barbell Deadlift", "Surrenders", "Toe Taps", "TRX Leg Curls", "TRX Straps Glute Bridge", "TRX Straps Overhead Squats", "TRX Lateral Lunges", "TRX Suspension Straps Squats", "Turkish Get Ups", "Two-Arm Kettlebell Squat Swings", "Soldier March", "Wall Sit Chair Squats", "Weighted Glute Bridges"};
    String[] Hamstrings = {"Twisting Jump Squats", "Agility Ladder Drills", "Air Squats", "Alternating Curtsy Lunge", "Barbell Box Squats", "Barbell High Pulls", "Barbell Overhead Squats", "Barbell Split Squats", "Box Jumps", "Lateral Lunges", "Bosu Ball Pistol Squats", "Butt Kicks", "Cardio – Walking", "Cardio – Crosstrainer Machine", "Cardio – Sprints", "Cardio – Stairmaster", "Cardio –Stairmill", "Cardio – Swimming", "Cardio – Riding", "Clamshells – Clams", "Crab Toe Touches", "Dumbbell Chops", "Dumbbell Step-Ups", "Dumbbell Walking Lunges", "Jumping Alternating Lunges", "Roller Hamstring Stretch", "Frog Jumps", "Front Kicks", "Hamstring Stretch", "Hex Squats", "Bridges", "Kettlebell Deadlifts", "Lunge with Bicep Hammer Curls", "Lying Leg Curls", "One Arm Kettlebell Swings", "Overhead Walking Lunges", "Power Skips", "Ragdoll Toe Touches", "Resistance Band Deadlifts", "Squat and Overhead Press", "Resistance Band Squats", "Reverse Dumbbell Lunges", "Romanian Deadlifts", "Lunge Stretch", "Seal Jacks", "Seated Leg Curls", "Skaters", "Single Leg Bodyweight Squats", "Single Leg Dumbbell Deadlift", "Sissy Squats", "Sled Push", "Machine Shoulder Press", "Smith Machine Squats", "Exercise Ball Hamstring Leg Curl", "Exercise Ball Squats", "Standing Hamstring Stretch", "Standing Knee Hugs", "Standing Hamstring Curls", "Water Break", "Step Up with Knee Raises", "Stiff Legged Barbell Deadlifts", "Sumo Barbell Deadlift", "Surrenders", "Toe Taps", "TRX Leg Curls", "TRX Strap Mountain Climbers", "Tuck Jumps", "Turkish Get Ups"};
    String[] Knees = {"Clamshells – Clams", "Machine Shoulder Press", "Water Break"};
    String[] Lower_Back = {"Agility Ladder Drills", "Barbell Deadlifts", "Barbell Good Morning", "Over Barbell Rows", "T-Bar Rows", "Alternating Reach & Kickbacks", "Backward Camel Stretch", "Clamshells – Clams", "Close Grip – Chinups", "Crab Toe Touches", "Crossbody Cable Rows", "Dumbbell Deadlifts", "Dumbbell Incline Bench Rows", "Lower Back Stretch", "Hex Squats", "Walkouts", "Reverse Pull-ups", "Kettlebell Deadlifts", "Kettlebell One-Legged Deadlifts", "Knee to Chest Lower Back Stretch", "One Arm Barbell Rows", "One Arm Kettlebell Rows", "Sandbag Good Mornings", "Pull-ups", "Rack Pulls", "Commando Rows", "Resistance Band Glute Bridges", "Scorpion Stretch", "Low Cable Back Rows", "Constructive Rest Position", "One Arm Dumbbell Bench Rows", "Machine Shoulder Press", "Exercise Ball Back Extensions", "Water Break", "Standing Over Dumbbell Rows", "Extended Arms & Legs Lifts", "Corpse Pose", "TRX Suspension Strap Rows", "Wide-Grip Pullovers"};
    String[] Middle_Back_Lats = {"Over Barbell Rows", "T-Bar Rows", "Row Squats", "Cardio – Swimming", "Clamshells – Clams", "Close Grip – Pullovers", "Crossbody Cable Rows", "Dumbbell Incline Bench Rows", "Gymnastic Ring Pull-ups", "Sit Pull-ups", "Machine Assited Pull-ups", "One Arm Barbell Rows", "Resistance Band Bent Over Rows", "Rope Climb", "Machine Back Row", "Machine Shoulder Press", "Water Break", "Straight Arm Pullovers", "TRX Pull-ups", "Turkish Get Ups", "Pullovers", "Weighted Pull-ups", "Wide-Grip Pullovers"};
    String[] Neck_Upper_Traps = {"Barbell Shoulder Shrugs", "Cable Shrugs", "Cardio – Swimming", "Clamshells – Clams", "Dumbbell Front Shoulder Raises", "Carry", "Plate Neck Resistance", "Neck Stretch", "Bent Over Rear Delt Raises", "Machine Shoulder Press", "Water Break"};
    String[] Obliques = {"Lying Oblique Reach", "Cross-body Crunches", "Bosu Ball Knee Tucks", "Bosu Ball Mountain Climbers", "Bosu Ball Plank", "Clamshells – Clams", "Body Mountain Climbers", "Double Side Jackknifes", "Cable Wood Chops", "Dumbbell Chops", "Leg Raises to Bar", "Hanging Windshield Wipers", "Kettlebell Windmills", "Knee Plank", "Lunge Twists", "Medicine Ball Woodchops", "Oblique Iso Hold", "Reverse Bench Crunches", "Hyperextension Bench Side Bends", "Slam", "Oblique Crunches", "Side Plank", "Dumbbell Suitcase Carry", "Machine Shoulder Press", "Standing Cross-body Crunches", "Standing Kettlebell Side Bends", "Water Break", "Upright Cable Wood Chops", "Weighted Mason Twists", "Windshield Wipers"};
    String[] Quadriceps = {"Twisting Jump Squats", "Agility Ladder Drills", "Air Squats", "Alternating Bodyweight Lunges", "Alternating Curtsy Lunge", "Barbell Box Squats", "Barbell Hack Squats", "Barbell High Pulls", "Barbell Lunges", "Barbell Overhead Squats", "Barbell Snatch", "Barbell Split Squats", "Barbell Squats", "Barbell Step-ups", "Rope Reverse Lunges", "Squatting Alternating Waves", "Box Jumps", "Lateral Lunges", "Squats", "Walking Lunges", "Bosu Ball Pistol Squats", "Bosu Ball Squats", "Bosu Ball Static Balance", "Bulgarian Split Squats", "Butt Kicks", "Cable Adduction", "Row Squats", "Cardio – Walking", "Cardio – Crosstrainer Machine", "Cardio – Elliptical Machine", "Cardio – Recumbent Bike", "Cardio – Rowing Machine", "Cardio –Treadmill", "Cardio – Sprints", "Cardio – Stairmaster", "Cardio –Stairmill", "Cardio –Spinning", "Cardio – Swimming", "Cardio – Riding", "Chair Squats", "Clamshells – Clams", "Crab Toe Touches", "Dumbbell Chops", "Dumbbell Lunges", "Dumbbell Lateral Lunges", "Dumbbell Squat Clean and Press", "Dumbbell Squat to Overhead Press", "Dumbbell Squats", "Dumbbell Step-Ups", "Dumbbell Walking Lunges", "Jumping Alternating Lunges", "Roller Quadriceps Stretch", "Frog Jumps", "Front Barbell Squats", "Front Kicks", "Goblet Squats", "Hex Squats", "High Box Jumps", "Hindu Squats", "Jump Squats", "Star Jumps", "Kettlebell Squats", "Kettlebell Squat to Overhead Press", "Machine Squat Press", "Lunge - Front Kicks", "Lunge Twists", "Lunge with Bicep Hammer Curls", "Machine Hack Squats", "Single-Leg Extended Arm Squats", "Overhead Walking Lunges", "Power Skips", "Sandbag Lunges", "Sandbag Squats", "Resistance Band Lying Leg Extensions", "Squat and Overhead Press", "Resistance Band Squats", "Reverse Dumbbell Lunges", "Lunge Stretch", "Seal Jacks", "Machine Leg Extensions", "Skaters", "Lying Quad Stretch", "Side Jump Squats", "Single Leg Bodyweight Squats", "Sissy Squats", "Sled Push", "Machine Shoulder Press", "Smith Machine Squats", "Alternating Squat Jumps", "Exercise Ball Squats", "Standing Long Jumps", "Standing Quadricep Stretch", "Water Break", "Static Squat Hold", "Step Up with Knee Raises", "Plié Dumbbell Squats", "Sumo Barbell Deadlift", "Surrenders", "Toe Taps", "TRX Single Leg Squats", "TRX Leg Curls", "TRX Strap Mountain Climbers", "TRX Straps Overhead Squats", "TRX Lateral Lunges", "TRX Suspension Straps Squats", "TRX Straps Suspended Lunges", "Tuck Jumps", "Turkish Get Ups", "Two-Arm Kettlebell Squat Swings", "Wall Angles", "Wall Sit Chair Squats", "Sumo Barbell Squats"};
    String[] Shoulders = {"Overhead Press", "Barbell Front Raises", "Barbell High Pulls", "Barbell Push and Press", "Barbell Overhead Press", "Double Arm Slams", "Rope Double Waves", "Rope Jumping Jacks", "Side-to-Side Swings", "Battle Rope Snakes", "Squatting Alternating Waves", "Bear Crawls", "Bosu Ball Burpees", "Boxing with a Punching Bag", "Cable Upright Rows", "Cardio – Swimming", "Clamshells – Clams", "Crab Toe Touches", "Crab Walks", "Dumbbell Front Shoulder Raises", "Dumbbell Flyes", "Biceps Curl to Shoulder Press", "Dumbbell Cuban Press", "Dumbbell Overhead Shoulder Press", "Dumbbell Shrugs", "Dumbbell Squat Clean and Press", "Dumbbell Squat to Overhead Press", "Cable Shoulder Rotation", "Rear Delt Pull", "Carry", "Front Shoulder Dumbbell Raises", "Ring Support Position", "Handstand Push-ups", "Internal Cable Shoulder Rotation", "Kettlebell Single Arm Clean and Press", "Kettlebell Squat to Overhead Press", "Landmine Press", "Lateral Power Partials", "Lateral Raise Machine", "Seated Shoulder Press", "Ball Rotational Passes", "Medicine Ball Slams", "Ball Wall Throw", "One Arm Kettlebell Swings", "One Arm Kettlebell Push and Press", "One Arm Kettlebell Snatch", "Walking Plank Up-Downs", "Overhead Walking Lunges", "Rear Delt Machine Flyes", "Resistance Band Side Raises", "Resistance Band Shoulder Front Raises", "Squat and Overhead Press", "Resistance Band Overhead Press", "Reverse Flyes", "Scarecrows", "Bent Over Rear Delt Raises", "Arnold Dumbbell Press", "Barbell Military Press", "Front Raises Raises", "Side Shoulder Dumbbell Raises", "Shoulder Hammer Press", "Single Arm Dumbbell Tricep Extensions", "Shadow Boxing", "Broomstick Stretch", "Shoulder Stretch", "Slam", "Side Raise", "Machine Shoulder Press", "Exercise Ball Dumbbell Shoulder Press", "Exercise Ball Push-ups", "Staggered Hand Push-ups", "Standing Arm Circles", "Standing Barbell Shoulder Press", "Standing Overhead Shoulder Press", "Standing Kettlebell Raises", "Overhead Barbell Shoulder Press", "Water Break", "TRX Supension Straps Push-ups", "TRX Deltoid Y Flyes", "TRX Straps Saw Pikes", "Turkish Get Ups", "Two-Arm Kettlebell Squat Swings", "Underhand Grip Barbell Bench Press", "Upright Barbell Rows", "Upright Dumbbell Rows", "Upright Kettlebell Front Rows", "Wall Angles"};
    String[] Spine = {"Clamshells – Clams", "Machine Shoulder Press", "Water Break"};
    String[] Triceps = {"Machine Seated Tricep Dips", "Assisted Tricep Dips", "Barbell Push-ups", "Side-to-Side Swings", "Arm Tricep Kickbacks", "Bosu Ball Burpees", "Bosu Ball Chest Dumbbell Press", "Boxing with a Punching Bag", "Overhead Triceps Extensions", "Cable Triceps Kickbacks", "Bench Tricep Dips", "Clamshells – Clams", "Close Grip – Barbell Bench Press", "Decline Dumbbell Flyes", "Decline Skull Crushers", "Diamond Push-ups", "Barbell Skull Crushers", "Gymnastic Ring Dips", "Ring Support Position", "Incline Close-grip Bench Press", "Dumbbell Tricep Extensions", "Overhead Triceps Stretch", "Resistance Band Tricep Kickbacks", "Tricep Overhead Extensions", "Triceps Bench Press", "Single Arm Dumbbell Tricep Extensions", "Overhead Extensions", "Shadow Boxing", "Machine Shoulder Press", "Spiderman Push-ups", "Exercise Ball Dumbbell Chest Press", "Exercise Ball Push-ups", "Standing Barbell Triceps Extensions", "Water Break", "Triceps Pull Downs", "Tricep Dumbbell Kickbacks", "Triceps Dips", "TRX Straps Tricep Extensions", "Underhand Grip Barbell Bench Press", "Standing Press Ups", "Weighted Bench Dips", "Weighted Tricep Dips"};
    String[] Upper_Back_Lower_Traps = {"Barbell Chest Overhead Extensions", "Double Arm Slams", "Rope Double Waves", "Rope Jumping Jacks", "Battle Rope Snakes", "Bosu Ball Burpees", "Boxing with a Punching Bag", "Clamshells – Clams", "Crab Toe Touches", "Dumbbell Pullovers", "Upper Back Stretch", "Gymnastic Ring Pull-ups", "Reverse Pull-ups", "Medicine Ball Slams", "Ball Wall Throw", "Muscle Ups", "One Arm Kettlebell Rows", "Pull-ups", "Commando Rows", "Crossovers", "Barbell Military Press", "One Arm Dumbbell Bench Rows", "Machine Shoulder Press", "Water Break", "TRX Strap T Flyes", "Upright Kettlebell Front Rows"};
    String[] Wrists = {"Clamshells – Clams", "Machine Shoulder Press", "Water Break"};
    String[] Cardio = {"Cardio – Crosstrainer Machine", "Cardio – Elliptical Machine", "Cardio – Recumbent Bike", "Cardio – Rowing Machine", "Cardio –Treadmill", "Cardio – Sprints", "Cardio – Stairmaster", "Cardio –Stairmill", "Cardio –Spinning", "Cardio – Swimming", "Cardio – Walking", "Cardio – Riding"};
    String[] Exercise_Break = {"Water Break"};

    int[] Chests_Int = {	R.drawable.barbellbenchpress_chestpress,	R.drawable.barbellpullovers_lyingchestoverheadextensions,	R.drawable.barbellpushups_push_ups,	R.drawable.bosuballchestdumbbellflyes_flies,	R.drawable.bosuballchestdumbbellpress,	R.drawable.bosuballpush_ups_pushups,	R.drawable.butterflystretch,	R.drawable.cardio_swimming,	R.drawable.clamshells_clams,	R.drawable.declinebarbellbenchpress,	R.drawable.declinebenchdumbbellpress,	R.drawable.declinedumbbellflyes,	R.drawable.declinepush_ups_pushups,	R.drawable.dumbbellflatbenchpress,	R.drawable.dumbbellfloorchestpress,	R.drawable.dumbbellpullovers,	R.drawable.dynamicclappush_ups_pushups,	R.drawable.flatbenchdumbbellflyes,	R.drawable.foamrollerchestopenerstretch,	R.drawable.gymnasticringdips,	R.drawable.hammerstrengthmachine_seatedchestpress,	R.drawable.hindu_judopush_up_divebombers,	R.drawable.inclinebarbellbenchchestpress,	R.drawable.inclinebenchdumbbellflyes,	R.drawable.inclineclose_gripbenchpress,	R.drawable.inclinedumbbellbenchchestpress,	R.drawable.inclinepush_ups_pushups,	R.drawable.landminepress,	R.drawable.lowupwardcablepulleycrossoverchestflyes,	R.drawable.medicineballchestpass,	R.drawable.medicineballpush_ups,	R.drawable.medicineballrotationalpasses,	R.drawable.medicineballslams,	R.drawable.modified_kneepush_ups_pushups,	R.drawable.muscleups,	R.drawable.push_ups_pushups,	R.drawable.resistancebandchestpress,	R.drawable.resistancebandpush_ups_pushups,	R.drawable.side_lateralmedicineballthrow_slam,	R.drawable.singlearmchestpress,	R.drawable.singlearmmedicineballpush_ups_pushups,	R.drawable.smithmachinebenchchestpress,	R.drawable.smithmachineshoulderpress,	R.drawable.spidermanpush_ups_pushups,	R.drawable.stability_swiss_exerciseballdumbbellchestflyes,	R.drawable.stability_swiss_exerciseballdumbbellchestpress,	R.drawable.stability_swiss_exerciseballpushups_push_ups,	R.drawable.staggeredhandpush_ups_pushups,	R.drawable.standingcablechestpress,	R.drawable.standingcablecrossoverpress_flyes,	R.drawable.standingrest_waterbreak,	R.drawable.staticpush_up_pushuphold,	R.drawable.trxsuspensionstrapsatomicpush_ups_pushups,	R.drawable.trxsuspensionstrapschestpress,	R.drawable.turkishgetups,	R.drawable.underhandgripbarbellbenchpress,	R.drawable.wallpush_ups_pushups_standingpressups,	R.drawable.widearmcheststretch_reversebutterflystretch,	R.drawable.widepush_ups_pushups};
    int[] Abs_Int = {	R.drawable.abcrunchmachine,	R.drawable.abroller_wheelrollout_kneelingrollextensions,	R.drawable.agilityladderdrills,	R.drawable.battleropedoublearmslams,	R.drawable.battleropedoublewaves,	R.drawable.battleropejumpingjacks,	R.drawable.battleropeside_to_sideswings,	R.drawable.battleropesnakes,	R.drawable.battleropesquattingalternatingwaves,	R.drawable.bearcrawls,	R.drawable.benchflutterkicks,	R.drawable.bicycles_elbow_to_kneecrunches_cross_bodycrunches,	R.drawable.birddogs_alternatingreachkickbacks,	R.drawable.bosuballchestdumbbellflyes_flies,	R.drawable.bosuballlegpull_in_kneetucks,	R.drawable.bosuballmountainclimbers,	R.drawable.bosuballplank,	R.drawable.bosuballplankleglifts,	R.drawable.bosuballpush_ups_pushups,	R.drawable.bosuballv_ups,	R.drawable.burpees_squatthrusts,	R.drawable.cablecorerotation,	R.drawable.captainschairleg_knee_hipraises,	R.drawable.clamshells_clams,	R.drawable.cobraabdominalstretch_oldhorsestretch,	R.drawable.crunches,	R.drawable.deadbug,	R.drawable.declinebenchcrunches_sit_ups,	R.drawable.doublecrunches,	R.drawable.doublesidejackknifes,	R.drawable.dumbbellweightedlegpull_ins,	R.drawable.flutterkicks,	R.drawable.gymnasticringl_holds,	R.drawable.hangingkneeraises,	R.drawable.hanginglegraises,	R.drawable.hanginglegraisestobar,	R.drawable.hangingwindshieldwipers,	R.drawable.highknees_frontkneelifts_run_jogonthespot,	R.drawable.hindu_judopush_up_divebombers,	R.drawable.hollowbodyrockhold,	R.drawable.inchworms_walkouts,	R.drawable.jackknifesit_up_crunch_toetouches,	R.drawable.kettlebellaroundtheworlds,	R.drawable.kettlebelldeadlifts,	R.drawable.kettlebellwindmills,	R.drawable.kneeplank,	R.drawable.kneelingcablecrunches,	R.drawable.legpull_inknee_up,	R.drawable.lyinglegraise_lift,	R.drawable.medicineballchestpass,	R.drawable.medicineballrotationalpasses,	R.drawable.medicineballslams,	R.drawable.medicineballv_ups,	R.drawable.medicineballwallthrow,	R.drawable.mountainclimbers_alternatingknee_ins,	R.drawable.palloffpress_obliqueisohold,	R.drawable.plank,	R.drawable.plankjacks_extendedleg,	R.drawable.plankkneetoelbow,	R.drawable.plankleglift,	R.drawable.planktopush_uppushupswalkingplankup_downs,	R.drawable.reversebenchcrunches,	R.drawable.reversecrunch,	R.drawable.russian_mason_v_sittwists,	R.drawable.scarecrows,	R.drawable.seatedbenchlegpull_ins_flatbenchknee_ups,	R.drawable.seatedvacuum,	R.drawable.shadowboxing,	R.drawable.side_lateralmedicineballthrow_slam,	R.drawable.sideplanklegraises,	R.drawable.sit_ups,	R.drawable.smithmachineshoulderpress,	R.drawable.snapjumps,	R.drawable.stability_swiss_exerciseballabpikepress,	R.drawable.swissballcrunch,	R.drawable.stability_swiss_exerciseballdumbbellchestflyes,	R.drawable.stability_swiss_exerciseballkneetucktochest,	R.drawable.stability_swiss_exerciseballrollout,	R.drawable.staggeredhandpush_ups_pushups,	R.drawable.standingcross_bodycrunches,	R.drawable.standingfrontshoulderplatedumbbellkettlebellraises,	R.drawable.standingrest_waterbreak,	R.drawable.standingtrxsuspensionstrapabrollout,	R.drawable.staticpush_up_pushuphold,	R.drawable.swissballhandoff_v_pass,	R.drawable.swissballleglifts,	R.drawable.swissballplank,	R.drawable.trxsuspensionstrapmountainclimbers,	R.drawable.trxsuspensionstrapsatomicpush_ups_pushups,	R.drawable.trxsuspensionstrapssawpikes,	R.drawable.upwardcablewoodchops,	R.drawable.walkinghighkicks_soldiermarch,	R.drawable.weightedrussian_masontwists,	R.drawable.windshieldwipers};
    int[] Ankle_Int = {	R.drawable.clamshells_clams,	R.drawable.smithmachineshoulderpress,	R.drawable.standingrest_waterbreak};
    int[] Biceps_Int = {	R.drawable.barbellcurls_standingbicepscurls,	R.drawable.barbelldragbicepcurls,	R.drawable.battleropereverselunges,	R.drawable.battleropeside_to_sideswings,	R.drawable.behind_the_backstandingbicepcurls,	R.drawable.bosuballburpees,	R.drawable.boxingwithapunchingbag,	R.drawable.cablehammerbicepcurls,	R.drawable.clamshells_clams,	R.drawable.dumbbellbicepscurltoshoulderpress,	R.drawable.exercise_swissballbicepcurls,	R.drawable.ez_barpreachercurls,	R.drawable.machinebiceppreacher_concentrationcurls,	R.drawable.one_armdumbbellpreachercurl,	R.drawable.overheadcablecurl_crucifixcurls,	R.drawable.resistancebandbicepcurls,	R.drawable.reversegripezcurlbarcurls,	R.drawable.seatedalternatinginclinebenchdumbbellcurls,	R.drawable.seateddumbbellbicepcurls,	R.drawable.seateddumbbellconcentrationcurls,	R.drawable.shadowboxing,	R.drawable.smithmachineshoulderpress,	R.drawable.standingbicepcablecurls,	R.drawable.standingdumbbellbicepcurls,	R.drawable.standingdummbellbicephammercurls,	R.drawable.standingrest_waterbreak,	R.drawable.standingreversebarbellcurls,	R.drawable.staticbicepcurls,	R.drawable.trxsuspensionstrapbicepcurls};

    int[] Calves_Int = {	R.drawable.twistingjumpsquats,	R.drawable.agilityladderdrills,	R.drawable.barbelloverheadsquats,	R.drawable.barbellsplitsquats,	R.drawable.battleropejumpingjacks,	R.drawable.bodyweightcalfraises,	R.drawable.cardio_walking,	R.drawable.cardio_sprints,	R.drawable.cardio_roadbike_cycling_riding,	R.drawable.clamshells_clams,	R.drawable.foamrollercalf_calvesstretch,	R.drawable.jumpingjacks_starjumps,	R.drawable.legpressmachinecalfraises,	R.drawable.ragdoll_forwardbend_foldstretch_toetouches,	R.drawable.ropejumping_jumprope_skipping,	R.drawable.sealjacks,	R.drawable.seatedcalfraises,	R.drawable.smithmachineshoulderpress,	R.drawable.standingbarbellcalfraises,	R.drawable.standingdumbbellcalfraises,	R.drawable.standingrest_waterbreak,	R.drawable.straight_legcalfstretch};

    int[] Forearms_Int = {	R.drawable.clamshells_clams,	R.drawable.dumbbellbicepreversecurls,	R.drawable.farmerswalk_carry,	R.drawable.seatedpalm_downwristcurls,	R.drawable.seatedpalm_upwristcurls,	R.drawable.smithmachineshoulderpress,	R.drawable.standingrest_waterbreak};

    int[] Glutes_Hip_Flexors_Int = {	R.drawable.adductor_abductor_adductioninnerthighmachine,	R.drawable.agilityladderdrills,	R.drawable.barbellboxsquats,	R.drawable.barbellhipthrusts,	R.drawable.barbellkneelingsquats,	R.drawable.barbellsnatch,	R.drawable.barbellsquats,	R.drawable.barbellstep_ups,	R.drawable.battleropereverselunges,	R.drawable.bodyweightsidesteps_laterallunges,	R.drawable.bodyweightsquats,	R.drawable.bosuballplankleglifts,	R.drawable.bosuballsinglelegbridge_hipthrusts_extensions_raises,	R.drawable.bosuballsquats,	R.drawable.burpees_squatthrusts,	R.drawable.buttkicks,	R.drawable.cablehipextensions,	R.drawable.cardio_crosstrainer_crosstrainermachine,	R.drawable.cardio_sprints,	R.drawable.cardio_stairmaster,	R.drawable.cardio_swimming,	R.drawable.chairsquats,	R.drawable.clamshells_clams,	R.drawable.crabwalks,	R.drawable.donkeykicks,	R.drawable.dumbbelldeadlifts,	R.drawable.dumbbelllunges,	R.drawable.dumbbellsquatcleanandpress,	R.drawable.firehydrants_abductor_adductorkneeraises,	R.drawable.foamrollerglutes_buttstretch,	R.drawable.foamrollerouterthighsstretch,	R.drawable.forwardleghipswings,	R.drawable.frontbarbellsquats,	R.drawable.gluteus_glute_glutealstretch,	R.drawable.groiners,	R.drawable.highboxjumps,	R.drawable.hindusquats,	R.drawable.hipcircles,	R.drawable.hipraises_buttlift_bridges,	R.drawable.inchworms_walkouts,	R.drawable.jumpingcalfpress_raises,	R.drawable.jumpsquats,	R.drawable.kettlebellaroundtheworlds,	R.drawable.kettlebellsquats,	R.drawable.kneelinghipflexorstretch,	R.drawable.legpress_machinesquatpress,	R.drawable.lunge_frontkicks,	R.drawable.lungetwists,	R.drawable.lunging_lungewithbicephammercurls,	R.drawable.lyingsideleglifts_lateralraises_hipabductors_adductors,	R.drawable.machinehacksquats,	R.drawable.mountainclimbers_alternatingknee_ins,	R.drawable.one_armkettlebellpushandpress,	R.drawable.one_armkettlebellsnatch,	R.drawable.piriformisstretch,	R.drawable.pistol_single_legextendedarmsquats,	R.drawable.plankjacks_extendedleg,	R.drawable.plankkneetoelbow,	R.drawable.powerbag_sandbaggoodmornings,	R.drawable.powerbag_sandbaglunges,	R.drawable.powerbag_sandbagsquats,	R.drawable.resistancebandclamshells,	R.drawable.resistancebanddeadlifts,	R.drawable.resistancebandglutebridges,	R.drawable.resistancebandglutekickbacks,	R.drawable.resistancebandlyinglegextensions,	R.drawable.resistancebandsidesteps,	R.drawable.ropejumping_jumprope_skipping,	R.drawable.roundhousekicks,	R.drawable.samsonstretch_lungestretch,	R.drawable.sidelateralleg_hipswings,	R.drawable.sideplanklegraises,	R.drawable.singlelegbenchbodyweightsquats,	R.drawable.singlelegglutebridge_hipextensionwithleglift,	R.drawable.singlelegswissballhipsraises_legcurls,	R.drawable.sissysquats,	R.drawable.sledpush,	R.drawable.smithmachineshoulderpress,	R.drawable.snapjumps,	R.drawable.stability_swiss_exerciseballabpikepress,	R.drawable.standingadductor_adductionstretch,	R.drawable.standingkneehugs,	R.drawable.standinglongjumps,	R.drawable.standingrest_waterbreak,	R.drawable.sumo_pliedumbbellsquats,	R.drawable.sumobarbelldeadlift,	R.drawable.surrenders,	R.drawable.toetaps,	R.drawable.trxsuspensionstraphamstring_legcurls,	R.drawable.trxsuspensionstrapsglutebridge,	R.drawable.trxsuspensionstrapsoverheadsquats,	R.drawable.trxsuspensionstrapssidestep_laterallunges,	R.drawable.trxsuspensionstrapssquats,	R.drawable.turkishgetups,	R.drawable.two_armkettlebellsquatswings,	R.drawable.walkinghighkicks_soldiermarch,	R.drawable.wallsit_squats_chair,	R.drawable.weightedglutebridges};

    int[] Hamstrings_Int = {	R.drawable.twistingjumpsquats,	R.drawable.agilityladderdrills,	R.drawable.airsquats,	R.drawable.alternatingcurtsylunge,	R.drawable.barbellboxsquats,	R.drawable.barbellhighpulls,	R.drawable.barbelloverheadsquats,	R.drawable.barbellsplitsquats,	R.drawable.benchhops_boxjumps,	R.drawable.bodyweightsidesteps_laterallunges,	R.drawable.bosuballsingleleg_pistolsquats,	R.drawable.butterflies_pecdeck_seatedmachineflyes,	R.drawable.cardio_walking,	R.drawable.cardio_crosstrainer_crosstrainermachine,	R.drawable.cardio_sprints,	R.drawable.cardio_stairmaster,	R.drawable.cardio_stairmaster_stairmill,	R.drawable.cardio_swimming,	R.drawable.cardio_roadbike_cycling_riding,	R.drawable.clamshells_clams,	R.drawable.crabtoetouches,	R.drawable.dumbbellchops,	R.drawable.dumbbellstep_ups,	R.drawable.dumbbellwalkinglunges,	R.drawable.explosivejumpingalternatinglunges,	R.drawable.foamrollerhamstringstretch,	R.drawable.frogjumps,	R.drawable.frontkicks,	R.drawable.hamstringstretch,	R.drawable.hex_trapbar_cagedeadlifts_squats,	R.drawable.hipraises_buttlift_bridges,	R.drawable.kettlebelldeadlifts,	R.drawable.lunging_lungewithbicephammercurls,	R.drawable.lyinglegcurls,	R.drawable.onearmkettlebellswings,	R.drawable.plateoverheadwalkinglunges,	R.drawable.powerskips,	R.drawable.ragdoll_forwardbend_foldstretch_toetouches,	R.drawable.resistancebanddeadlifts,	R.drawable.resistancebandsquatandoverheadpress,	R.drawable.resistancebandsquats,	R.drawable.reversedumbbelllunges,	R.drawable.romaniandeadlifts,	R.drawable.samsonstretch_lungestretch,	R.drawable.sealjacks,	R.drawable.seatedlegcurls,	R.drawable.side_lateralsuffles_hops_skaters,	R.drawable.singlelegbenchbodyweightsquats,	R.drawable.singlestraightlegdumbbelldeadlift,	R.drawable.sissysquats,	R.drawable.sledpush,	R.drawable.smithmachineshoulderpress,	R.drawable.smithmachinesquats,	R.drawable.stability_swiss_exerciseballhamstringlegcurl_hipraise_bridge,	R.drawable.stability_swiss_exerciseballsquats,	R.drawable.standinghamstringstretch,	R.drawable.standingkneehugs,	R.drawable.standingleg_hamstringcurls,	R.drawable.standingrest_waterbreak,	R.drawable.stepupwithkneeraises,	R.drawable.stiffleggedbarbelldeadlifts,	R.drawable.sumobarbelldeadlift,	R.drawable.surrenders,	R.drawable.toetaps,	R.drawable.trxsuspensionstraphamstring_legcurls,	R.drawable.trxsuspensionstrapmountainclimbers,	R.drawable.tuckjumps,	R.drawable.turkishgetups};
    int[] Knees_Int = {R.drawable.clamshells_clams, R.drawable.smithmachineshoulderpress, R.drawable.standingrest_waterbreak};
    int[] Lower_Back_Int = {	R.drawable.agilityladderdrills,	R.drawable.barbelldeadlifts,	R.drawable.barbellgoodmorning,	R.drawable.bentoverbarbellrows,	R.drawable.bentovertwo_armlongbarbell_t_barrows,	R.drawable.birddogs_alternatingreachkickbacks,	R.drawable.catback_backwardcamelstretch,	R.drawable.clamshells_clams,	R.drawable.closegrippullups_chinups,	R.drawable.crabtoetouches,	R.drawable.crossbodycablerows,	R.drawable.dumbbelldeadlifts,	R.drawable.dumbbellinclinebenchrows,	R.drawable.foamrollerlowerbackstretch,	R.drawable.hex_trapbar_cagedeadlifts_squats,	R.drawable.inchworms_walkouts,	R.drawable.invertedrows_reversepull_ups,	R.drawable.kettlebelldeadlifts,	R.drawable.kettlebellone_leggeddeadlifts,	R.drawable.knee_to_chestlowerbackstretch,	R.drawable.onearmbarbellrows,	R.drawable.one_armkettlebellrows,	R.drawable.powerbag_sandbaggoodmornings,	R.drawable.pull_ups,	R.drawable.rackpulls,	R.drawable.renegade_alternatingplank_commandorows,	R.drawable.resistancebandglutebridges,	R.drawable.scorpionstretch,	R.drawable.seated_lowcablebackrows,	R.drawable.semi_supinelayingdown_constructiverestposition,	R.drawable.single_onearmdumbbellbenchrows,	R.drawable.smithmachineshoulderpress,	R.drawable.stability_swiss_exerciseballbackextensions,	R.drawable.standingrest_waterbreak,	R.drawable.standingtwo_armedbentoverdumbbellrows,	R.drawable.supermans_extendedarmslegslifts,	R.drawable.supinelyingdownposition_corpsepose,	R.drawable.trxsuspensionstraprows,	R.drawable.wide_griplatpulldowns_pulldowns_pullovers};
    int[] Middle_Back_Lats_Int = {	R.drawable.bentoverbarbellrows,	R.drawable.bentovertwo_armlongbarbell_t_barrows,	R.drawable.cablesquatrows_rowsquats,	R.drawable.cardio_swimming,	R.drawable.clamshells_clams,	R.drawable.closegriplatpulldowns_pulldowns_pullovers,	R.drawable.crossbodycablerows,	R.drawable.dumbbellinclinebenchrows,	R.drawable.gymnasticringpull_ups_pullups,	R.drawable.l_sitpullups,	R.drawable.machineassistedpull_ups_pullups,	R.drawable.onearmbarbellrows,	R.drawable.resistancebandbentoverrows,	R.drawable.ropeclimb,	R.drawable.seatedmachinebackrow,	R.drawable.smithmachineshoulderpress,	R.drawable.standingrest_waterbreak,	R.drawable.straightarmpulldowns_pulldowns_pullovers,	R.drawable.trxpullups,	R.drawable.turkishgetups,	R.drawable.v_bar_trianglebarlatpulldowns_pulldowns_pullovers,	R.drawable.weightedpull_ups_pullups,	R.drawable.wide_griplatpulldowns_pulldowns_pullovers};
    int[] Neck_Upper_Traps_Int = {	R.drawable.barbellshouldershrugs,	R.drawable.cableshrugs,	R.drawable.cardio_swimming,	R.drawable.clamshells_clams,	R.drawable.dual_twoarmdumbbellfrontshoulderraises,	R.drawable.farmerswalk_carry,	R.drawable.lyingfacedownplateneckresistance,	R.drawable.neckstretch,	R.drawable.seated_bentoverreardeltraises,	R.drawable.smithmachineshoulderpress,	R.drawable.standingrest_waterbreak};
    int[] Obliques_Int = {	R.drawable.alternateheeltouchers_lyingobliquereach,	R.drawable.bicycles_elbow_to_kneecrunches_cross_bodycrunches,	R.drawable.bosuballlegpull_in_kneetucks,	R.drawable.bosuballmountainclimbers,	R.drawable.bosuballplank,	R.drawable.clamshells_clams,	R.drawable.crossbodymountainclimbers,	R.drawable.doublesidejackknifes,	R.drawable.downwardcablewoodchops,	R.drawable.dumbbellchops,	R.drawable.hanginglegraisestobar,	R.drawable.hangingwindshieldwipers,	R.drawable.kettlebellwindmills,	R.drawable.kneeplank,	R.drawable.lungetwists,	R.drawable.medicineballwoodchops_chops,	R.drawable.palloffpress_obliqueisohold,	R.drawable.reversebenchcrunches,	R.drawable.romanchair_hyperextensionbenchsidebends,	R.drawable.side_lateralmedicineballthrow_slam,	R.drawable.side_obliquecrunches,	R.drawable.sideplank,	R.drawable.singlearmdumbbell_suitcasecarry,	R.drawable.smithmachineshoulderpress,	R.drawable.standingcross_bodycrunches,	R.drawable.standingdumbbell_kettlebellsidebends,	R.drawable.standingrest_waterbreak,	R.drawable.upwardcablewoodchops,	R.drawable.weightedrussian_masontwists,	R.drawable.windshieldwipers};
    int[] Quadriceps_Int = {	R.drawable.twistingjumpsquats,	R.drawable.agilityladderdrills,	R.drawable.airsquats,	R.drawable.alternatingbodyweightlunges,	R.drawable.alternatingcurtsylunge,	R.drawable.barbellboxsquats,	R.drawable.barbellhacksquats,	R.drawable.barbellhighpulls,	R.drawable.barbelllunges,	R.drawable.barbelloverheadsquats,	R.drawable.barbellsnatch,	R.drawable.barbellsplitsquats,	R.drawable.barbellsquats,	R.drawable.barbellstep_ups,	R.drawable.battleropereverselunges,	R.drawable.battleropesquattingalternatingwaves,	R.drawable.benchhops_boxjumps,	R.drawable.bodyweightsidesteps_laterallunges,	R.drawable.bodyweightsquats,	R.drawable.bodyweightwalkinglunges,	R.drawable.bosuballsingleleg_pistolsquats,	R.drawable.bosuballsquats,	R.drawable.bosuballstaticbalance,	R.drawable.bulgariansplitsquats,	R.drawable.butterflies_pecdeck_seatedmachineflyes,	R.drawable.cablehipabduction_adduction,	R.drawable.cablesquatrows_rowsquats,	R.drawable.cardio_walking,	R.drawable.cardio_crosstrainer_crosstrainermachine,	R.drawable.cardio_ellipticalmachine,	R.drawable.cardio_recumbentbike,	R.drawable.cardio_rowingmachine,	R.drawable.cardio_running_jogging_treadmill,	R.drawable.cardio_sprints,	R.drawable.cardio_stairmaster,	R.drawable.cardio_stairmaster_stairmill,	R.drawable.cardio_stationarybike_spinning,	R.drawable.cardio_swimming,	R.drawable.cardio_roadbike_cycling_riding,	R.drawable.chairsquats,	R.drawable.clamshells_clams,	R.drawable.crabtoetouches,	R.drawable.dumbbellchops,	R.drawable.dumbbelllunges,	R.drawable.dumbbellsidelunges_laterallunges,	R.drawable.dumbbellsquatcleanandpress,	R.drawable.dumbbellsquats,	R.drawable.dumbbellsquatthrusters_squattooverheadpress,	R.drawable.dumbbellstep_ups,	R.drawable.dumbbellwalkinglunges,	R.drawable.explosivejumpingalternatinglunges,	R.drawable.foamrollerquadricepsstretch,	R.drawable.frogjumps,	R.drawable.frontbarbellsquats,	R.drawable.frontkicks,	R.drawable.gobletsquats,	R.drawable.hex_trapbar_cagedeadlifts_squats,	R.drawable.highboxjumps,	R.drawable.hindusquats,	R.drawable.jumpingcalfpress_raises,	R.drawable.jumpsquats,	R.drawable.kettlebellsquats,	R.drawable.kettlebellthruster_squattocleantooverheadpress,	R.drawable.legpress_machinesquatpress,	R.drawable.lunge_frontkicks,	R.drawable.lungetwists,	R.drawable.lunging_lungewithbicephammercurls,	R.drawable.machinehacksquats,	R.drawable.pistol_single_legextendedarmsquats,	R.drawable.plateoverheadwalkinglunges,	R.drawable.powerskips,	R.drawable.powerbag_sandbaglunges,	R.drawable.powerbag_sandbagsquats,	R.drawable.resistancebandlyinglegextensions,	R.drawable.resistancebandsquatandoverheadpress,	R.drawable.resistancebandsquats,	R.drawable.reversedumbbelllunges,	R.drawable.samsonstretch_lungestretch,	R.drawable.sealjacks,	R.drawable.seatedmachinelegextensions,	R.drawable.side_lateralsuffles_hops_skaters,	R.drawable.sidelyingquadstretch,	R.drawable.sidetosidejumpsquats,	R.drawable.singlelegbenchbodyweightsquats,	R.drawable.sissysquats,	R.drawable.sledpush,	R.drawable.smithmachineshoulderpress,	R.drawable.smithmachinesquats,	R.drawable.splitalternatingsquatjumps,	R.drawable.stability_swiss_exerciseballsquats,	R.drawable.standinglongjumps,	R.drawable.standingquadricepstretch,	R.drawable.standingrest_waterbreak,	R.drawable.staticsquathold,	R.drawable.stepupwithkneeraises,	R.drawable.sumo_pliedumbbellsquats,	R.drawable.sumobarbelldeadlift,	R.drawable.surrenders,	R.drawable.toetaps,	R.drawable.trxpistolsquats_trxsinglelegsquats,	R.drawable.trxsuspensionstraphamstring_legcurls,	R.drawable.trxsuspensionstrapmountainclimbers,	R.drawable.trxsuspensionstrapsoverheadsquats,	R.drawable.trxsuspensionstrapssidestep_laterallunges,	R.drawable.trxsuspensionstrapssquats,	R.drawable.trxsuspensionstrapssuspendedlunges,	R.drawable.tuckjumps,	R.drawable.turkishgetups,	R.drawable.two_armkettlebellsquatswings,	R.drawable.wallangles,	R.drawable.wallsit_squats_chair,	R.drawable.widestance_sumobarbellsquats};
    int[] Shoulders_Int ={	R.drawable.barbellcleanandpressjerkoverheadpress,	R.drawable.barbellfrontraises,	R.drawable.barbellhighpulls,	R.drawable.barbellpushandpress,	R.drawable.barbellshoulderpressoverheadpress,	R.drawable.battleropedoublearmslams,	R.drawable.battleropedoublewaves,	R.drawable.battleropejumpingjacks,	R.drawable.battleropeside_to_sideswings,	R.drawable.battleropesnakes,	R.drawable.battleropesquattingalternatingwaves,	R.drawable.bearcrawls,	R.drawable.bosuballburpees,	R.drawable.boxingwithapunchingbag,	R.drawable.cableuprightrows,	R.drawable.cardio_swimming,	R.drawable.clamshells_clams,	R.drawable.crabtoetouches,	R.drawable.crabwalks,	R.drawable.dual_twoarmdumbbellfrontshoulderraises,	R.drawable.dumbbellbentoverlateralreardeltraisesflyes,	R.drawable.dumbbellbicepscurltoshoulderpress,	R.drawable.dumbbellcubanpress,	R.drawable.dumbbelloverheadshoulderpress,	R.drawable.dumbbellshrugs,	R.drawable.dumbbellsquatcleanandpress,	R.drawable.dumbbellsquats,	R.drawable.externalcableshoulderrotation,	R.drawable.facepullreardeltpull,	R.drawable.farmerswalk_carry,	R.drawable.forwardfrontshoulderdumbbellraises,	R.drawable.gymnasticringsupportposition,	R.drawable.handstandpush_upspushups,	R.drawable.internalcableshoulderrotation,	R.drawable.kettlebellsinglearmcleanandpress,	R.drawable.kettlebellthruster_squattocleantooverheadpress,	R.drawable.landminepress,	R.drawable.lateralsideshoulderdumbbellraisespowerpartials,	R.drawable.lateralraisemachine,	R.drawable.machineseatedshoulderpress,	R.drawable.medicineballrotationalpasses,	R.drawable.medicineballslams,	R.drawable.medicineballwallthrow,	R.drawable.onearmkettlebellswings,	R.drawable.one_armkettlebellpushandpress,	R.drawable.one_armkettlebellsnatch,	R.drawable.planktopush_uppushupswalkingplankup_downs,	R.drawable.plateoverheadwalkinglunges,	R.drawable.reardeltmachineflyes,	R.drawable.resistancebandlateralraisessideraises,	R.drawable.resistancebandshoulderfrontraises,	R.drawable.resistancebandsquatandoverheadpress,	R.drawable.resistancebandstandingshoulderpressoverheadpress,	R.drawable.reverseflyes,	R.drawable.scarecrows,	R.drawable.seated_bentoverreardeltraises,	R.drawable.seatedarnolddumbbellpress,	R.drawable.seatedbarbellmilitarypress,	R.drawable.seateddualfrontraisesraises,	R.drawable.seatedlateralsideshoulderdumbbellraises,	R.drawable.seatedshoulderhammerpress,	R.drawable.seatedsinglearmoverheaddumbbelltricepextensions,	R.drawable.shadowboxing,	R.drawable.shoulderpolebroomstickstretch,	R.drawable.shoulderstretch,	R.drawable.side_lateralmedicineballthrow_slam,	R.drawable.singlearmcablelateralsideraiseworkoutlabs,	R.drawable.smithmachineshoulderpress,	R.drawable.stabilityswissexerciseballdumbbellshoulderpress,	R.drawable.stability_swiss_exerciseballpushups_push_ups,	R.drawable.staggeredhandpush_ups_pushups,	R.drawable.standingarmcircles,	R.drawable.standingbarbellshoulderpress,	R.drawable.standingdumbbelloverheadshoulderpress,	R.drawable.standingfrontshoulderplatedumbbellkettlebellraises,	R.drawable.standingoverheadmilitarybarbellshoulderpress,	R.drawable.standingrest_waterbreak,	R.drawable.trxsuspensionstrapsatomicpush_ups_pushups,	R.drawable.trxsuspensionstrapsdeltoidyflyes,	R.drawable.trxsuspensionstrapssawpikes,	R.drawable.turkishgetups,	R.drawable.two_armkettlebellsquatswings,	R.drawable.underhandgripbarbellbenchpress,	R.drawable.uprightbarbellrows,	R.drawable.uprightdumbbellrows,	R.drawable.uprightkettlebellfrontrows,	R.drawable.wallangles};
    int[] Spine_Int = {R.drawable.clamshells_clams, R.drawable.smithmachineshoulderpress, R.drawable.standingrest_waterbreak};
    int[] Triceps_Int = {	R.drawable.assisted_machineseatedtricepdips,	R.drawable.assistedtricepdips,	R.drawable.barbellpushups_push_ups,	R.drawable.battleropeside_to_sideswings,	R.drawable.bentoverdoublearmtricepkickbacks,	R.drawable.bosuballburpees,	R.drawable.bosuballchestdumbbellpress,	R.drawable.boxingwithapunchingbag,	R.drawable.cableropeoverheadtricepsextensions,	R.drawable.cabletricepskickbacks,	R.drawable.chair_benchtricepdips,	R.drawable.clamshells_clams,	R.drawable.close_gripoverhandbarbellbenchpress,	R.drawable.declinedumbbellflyes,	R.drawable.declinelyingtricepsextension_declineskullcrushers,	R.drawable.diamond_pyramid_tricepspush_ups_pushups,	R.drawable.flatbenchbarbellskullcrushers,	R.drawable.gymnasticringdips,	R.drawable.gymnasticringsupportposition,	R.drawable.inclineclose_gripbenchpress,	R.drawable.lyingdumbbelltricepextensions,	R.drawable.overheadtricepsstretch,	R.drawable.resistancebandtricepkickbacks,	R.drawable.resistancebandtricepoverheadextensions,	R.drawable.reversetricepsbenchpress,	R.drawable.seatedsinglearmoverheaddumbbelltricepextensions,	R.drawable.seatedtriceppress_overheadextensions,	R.drawable.shadowboxing,	R.drawable.smithmachineshoulderpress,	R.drawable.spidermanpush_ups_pushups,	R.drawable.stability_swiss_exerciseballdumbbellchestpress,	R.drawable.stability_swiss_exerciseballpushups_push_ups,	R.drawable.standingoverheadbarbelltricepsextensions,	R.drawable.standingrest_waterbreak,	R.drawable.tricepcableropepush_pulldowns,	R.drawable.tricepdumbbellkickbacks,	R.drawable.tricepsdips,	R.drawable.trxsuspensionstrapstricepextensions,	R.drawable.underhandgripbarbellbenchpress,	R.drawable.wallpush_ups_pushups_standingpressups,	R.drawable.weightedbenchdips,	R.drawable.weightedtricepdips};
    int[] Upper_Back_Lower_Traps_Int = {	R.drawable.barbellpullovers_lyingchestoverheadextensions,	R.drawable.battleropedoublearmslams,	R.drawable.battleropedoublewaves,	R.drawable.battleropejumpingjacks,	R.drawable.battleropesnakes,	R.drawable.bosuballburpees,	R.drawable.boxingwithapunchingbag,	R.drawable.clamshells_clams,	R.drawable.crabtoetouches,	R.drawable.dumbbellpullovers,	R.drawable.foamrollerupperbackstretch,	R.drawable.gymnasticringpull_ups_pullups,	R.drawable.invertedrows_reversepull_ups,	R.drawable.medicineballslams,	R.drawable.medicineballwallthrow,	R.drawable.muscleups,	R.drawable.one_armkettlebellrows,	R.drawable.pull_ups,	R.drawable.renegade_alternatingplank_commandorows,	R.drawable.reversecableflyes_crossovers,	R.drawable.seatedbarbellmilitarypress,	R.drawable.single_onearmdumbbellbenchrows,	R.drawable.smithmachineshoulderpress,	R.drawable.standingrest_waterbreak,	R.drawable.trxsuspensionstraptflyes,	R.drawable.uprightkettlebellfrontrows};
    int[] Wrists_Int = {R.drawable.clamshells_clams, R.drawable.smithmachineshoulderpress, R.drawable.standingrest_waterbreak};
    int[] Cardio_Int = {	R.drawable.cardio_crosstrainer_crosstrainermachine,	R.drawable.cardio_ellipticalmachine,	R.drawable.cardio_recumbentbike,	R.drawable.cardio_rowingmachine,	R.drawable.cardio_running_jogging_treadmill,	R.drawable.cardio_sprints,	R.drawable.cardio_stairmaster,	R.drawable.cardio_stairmaster_stairmill,	R.drawable.cardio_stationarybike_spinning,	R.drawable.cardio_swimming,	R.drawable.cardio_walking,	R.drawable.cardio_roadbike_cycling_riding};
    int[] Exercise_Break_Int = {R.drawable.standingrest_waterbreak};

    /*String[] Workouts_Title =
            {
                    "BarBell Bench Press",
                    "Decline Dumbbell Flyes",
                    "Decline Barbell Bench Press",
                    "Dumbbell Bench Press",
                    "DumbBell Flyes",
                    "Incline Cable Flyes",
                    "Incline Dumbbell Press",
                    "Low Cable Crossover",
                    "Pushups",
                    "Wide-grip barbell bench press"
            }; */


    //Initialize Adapter for how workouts view looks using customlist
    Workouts_View_Customlist workouts_list_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_workouts__view_);

        Activityname = getInitialActivityNameList();
        imageID = getInitialImageIDList();
        Weight = getInitialWeightList();
        Reps = getInitialRepsList();

        workouts_list_adapter = new Workouts_View_Customlist(this, Activityname, imageID, Weight, Reps);
        workouts_list_adapter.SetListEntries(this, Activityname, imageID, Weight, Reps);

        //Initialize list and set adapter to have custom settings
        final ListView list = (ListView) findViewById(R.id.Workouts_View_List);
        list.setAdapter(workouts_list_adapter);

        final FloatingActionButton FloatingButton = (FloatingActionButton) findViewById(R.id.fab_workouts_view);

        registerForContextMenu(list); //register list for context menu

        FloatingButton.setOnClickListener(new View.OnClickListener() {
                                              public void onClick(View v) {
                                                  //fabWorkoutspressed(workouts_list_adapter,list);
                                                  fab_clicked();
                                              }
                                          }
        );
    }

    private List<String> getInitialActivityNameList() {
        String LogFileName = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_ActivityName");
        List<String> Home_Screen_List = new ArrayList<String>();
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        String Compiled_String = sharedpref.getString(LogFileName, " ");

        String[] individual_entries = Compiled_String.split(",");

        for (int i = 0; i < individual_entries.length; i++) {
            if (individual_entries[i].trim().length() > 0)
                Home_Screen_List.add(individual_entries[i]);
        }
        return Home_Screen_List;
    }

    public void saveActivityNameList(String ActivityNameEntry) {
        String LogFileName = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_ActivityName");
        Activityname.add(ActivityNameEntry);
        StringBuilder Compiled_String = new StringBuilder();
        for (String s : Activityname) {
            Compiled_String.append(s);
            Compiled_String.append(",");
        }
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString(LogFileName, Compiled_String.toString());
        medit.commit(); //Save List even after app is closed

    }

    private List<Integer> getInitialImageIDList() {
        String LogFileName = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_ImageID");
        List<Integer> Home_Screen_List = new ArrayList<Integer>();
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        String Compiled_String = sharedpref.getString(LogFileName, " ");

        String[] individual_entries = Compiled_String.split(",");

        for (int i = 0; i < individual_entries.length; i++) {
            if (individual_entries[i].trim().length() > 0)
                Home_Screen_List.add(Integer.parseInt(individual_entries[i]));
        }
        return Home_Screen_List;
    }

    public void saveImageIDList(Integer imageIDEntry) {
        String LogFileName = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_ImageID");
        imageID.add(imageIDEntry);
        StringBuilder Compiled_String = new StringBuilder();
        for (Integer s : imageID) {
            Compiled_String.append(s.toString());
            Compiled_String.append(",");
        }

        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString(LogFileName, Compiled_String.toString());
        medit.commit(); //Save List even after app is closes
    }

    private List<String> getInitialWeightList() {
        String LogFileName = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_Weight");
        List<String> Home_Screen_List = new ArrayList<String>();
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        String Compiled_String = sharedpref.getString(LogFileName, " ");

        String[] individual_entries = Compiled_String.split(",");

        for (int i = 0; i < individual_entries.length; i++) {
            if (individual_entries[i].trim().length() > 0)
                Home_Screen_List.add(individual_entries[i]);
        }
        return Home_Screen_List;
    }

    public void saveWeightListEntry(String WeightEntry) {
        String LogFileName = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_Weight");
        Weight.add(WeightEntry);
        StringBuilder Compiled_String = new StringBuilder();
        for (String s : Weight) {
            Compiled_String.append(s);
            Compiled_String.append(",");
        }
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString(LogFileName, Compiled_String.toString());
        medit.commit(); //Save List even after app is closed

    }

    private List<String> getInitialRepsList() {
        String LogFileName = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_Reps");
        List<String> Home_Screen_List = new ArrayList<String>();
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        String Compiled_String = sharedpref.getString(LogFileName, " ");

        String[] individual_entries = Compiled_String.split(",");

        for (int i = 0; i < individual_entries.length; i++) {
            if (individual_entries[i].trim().length() > 0)
                Home_Screen_List.add(individual_entries[i]);
        }
        return Home_Screen_List;
    }

    public void saveRepsList(String RepsEntry) {
        String LogFileName = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_Reps");
        Reps.add(RepsEntry);
        StringBuilder Compiled_String = new StringBuilder();
        for (String s : Reps) {
            Compiled_String.append(s);
            Compiled_String.append(",");
        }
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString(LogFileName, Compiled_String.toString());
        medit.commit(); //Save List even after app is closed
    }

    //Called by activity when home FAB is pressed
  /*  public void fabWorkoutspressed(final Workouts_View_Customlist adapter, ListView list) {

        final AlertDialog newFragbuilder = new AlertDialog.Builder(this).create();
        final View log_workouts_entry_view = getLayoutInflater().inflate(R.layout.workout_fab_dialog_fragment, null);
        ListView workouts_dialog_list = (ListView) log_workouts_entry_view.findViewById(R.id.MyList);
        CustomList workouts_dialog_adapter = new CustomList(this,Workouts_Title, Workouts_Images);
        workouts_dialog_list.setAdapter(workouts_dialog_adapter);
        newFragbuilder.setView(log_workouts_entry_view);
        newFragbuilder.show();
        workouts_dialog_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Call activity to put in the weight and reps
                workout_activity_dialog_clicked(Workouts_Title[position], Workouts_Images[position],adapter);
                newFragbuilder.dismiss();
            }
        });
    }*/

    public void fab_clicked() {
        final AlertDialog newFragbuilder = new AlertDialog.Builder(this).create();
        final View DialogView = getLayoutInflater().inflate(R.layout.custom_list_item_image_text, null);

        List<String> list = new ArrayList<>();

        for (int i = 0; i < Workouts_Selection.length; i++) {
            list.add(Workouts_Selection[i]);
        }

        ListView Workouts_Individual_List = (ListView) DialogView.findViewById(R.id.Workouts_Individual_Contents_List);
        ArrayAdapter Workouts_Individual_Adapter = new ArrayAdapter<String>(this, R.layout.text_date_list, R.id.item2, list);
        Workouts_Individual_List.setAdapter(Workouts_Individual_Adapter);

        newFragbuilder.setView(DialogView);
        newFragbuilder.show();

        Workouts_Individual_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                newFragbuilder.dismiss();
                workout_selection_dialog_clicked(position);
            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflatemenu = getMenuInflater();
        inflatemenu.inflate(R.menu.menu_main, menu);

    }

    //Context Menu set up
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.Delete_Item:
                remove_item(menuInfo.position);
                //list_Adapter.notifyDataSetChanged();
                return true;
            case R.id.Modify_Item:
                ModifyItem(menuInfo.position);
                //  list_Adapter.notifyDataSetChanged();
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void ModifyItem(final Integer modifyposition) {
       /* final AlertDialog newFragbuilder = new AlertDialog.Builder(this).create();
        final View log_workouts_entry_view = getLayoutInflater().inflate(R.layout.workout_fab_dialog_fragment, null);
        ListView workouts_dialog_list = (ListView) log_workouts_entry_view.findViewById(R.id.MyList);
        CustomList workouts_dialog_adapter = new CustomList(this,Workouts_Title, Workouts_Images);
        workouts_dialog_list.setAdapter(workouts_dialog_adapter);
        newFragbuilder.setView(log_workouts_entry_view);
        newFragbuilder.setTitle("Select Activity");
        newFragbuilder.show();
        workouts_dialog_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Call activity to put in the weight and reps
                Modified_workout_activity_dialog_clicked(modifyposition, Workouts_Title[position], Workouts_Images[position]);
                newFragbuilder.dismiss();
            }
        });*/
    }

    public void Modified_workout_activity_dialog_clicked(final Integer position, final String workouts_title, final Integer image_id) {
        final AlertDialog newFragbuilder = new AlertDialog.Builder(this).create();
        final View weight_reps_fab_entry_view = getLayoutInflater().inflate(R.layout.weight_reps_fab_dialog, null);
        final EditText reps = (EditText) weight_reps_fab_entry_view.findViewById(R.id.reps_entry);
        final EditText weight = (EditText) weight_reps_fab_entry_view.findViewById(R.id.weight_entry);
        Button cancel = (Button) weight_reps_fab_entry_view.findViewById(R.id.cancel_button);
        Button ok = (Button) weight_reps_fab_entry_view.findViewById(R.id.ok_button);

        newFragbuilder.setView(weight_reps_fab_entry_view);
        newFragbuilder.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer repsInt = Integer.parseInt(reps.getText().toString());
                Integer weightInt = Integer.parseInt(weight.getText().toString());

                saveModifiedListEntries(position, workouts_title, image_id, ("Workout Reps: "+ repsInt.toString()), ("Weight/Resistance: " + weightInt.toString()));
                newFragbuilder.dismiss();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFragbuilder.dismiss();
            }
        });
        workouts_list_adapter.SetListEntries(this, Activityname, imageID, Weight, Reps);
        workouts_list_adapter.notifyDataSetChanged();
    }

    public void saveModifiedListEntries(Integer position, String activityName, Integer image_id, String reps, String weight) {
        String LogFileNameWeight = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_Weight");
        String LogFileNameImageID = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_ImageID");
        String LogFileNameActivity = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_ActivityName");
        String LogFileNameReps = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_Reps");

        Activityname.set(position, activityName);
        imageID.set(position, image_id);
        Weight.set(position, weight);
        Reps.set(position, reps);

        //Redo list with ","
        StringBuilder Compiled_String_Activity = new StringBuilder();
        for (String s : Activityname) {
            Compiled_String_Activity.append(s);
            Compiled_String_Activity.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString(LogFileNameActivity, Compiled_String_Activity.toString());
        medit.commit(); //Save List even after app is closed

        StringBuilder Compiled_String_ImageID = new StringBuilder();
        for (Integer s : imageID) {
            Compiled_String_ImageID.append(s.toString());
            Compiled_String_ImageID.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref_ImageID = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit_ImageID = sharedpref_ImageID.edit();
        medit_ImageID.putString(LogFileNameImageID, Compiled_String_ImageID.toString());
        medit_ImageID.commit(); //Save List even after app is closed

        StringBuilder Compiled_String_Weight = new StringBuilder();
        for (String s : Weight) {
            Compiled_String_Weight.append(s);
            Compiled_String_Weight.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref_Weight = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit_Weight = sharedpref_Weight.edit();
        medit_Weight.putString(LogFileNameWeight, Compiled_String_ImageID.toString());
        medit_Weight.commit(); //Save List even after app is closed

        StringBuilder Compiled_String_Reps = new StringBuilder();
        for (String s : Reps) {
            Compiled_String_Reps.append(s);
            Compiled_String_Reps.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref_Reps = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit_Reps = sharedpref_Reps.edit();
        medit_Reps.putString(LogFileNameReps, Compiled_String_Reps.toString());
        medit_Reps.commit(); //Save List even after app is closed]

        workouts_list_adapter.SetListEntries(this, Activityname, imageID, Weight, Reps);
        workouts_list_adapter.notifyDataSetChanged();
    }

    public void remove_item(int position) {
        //Remove item based off position from the list
        String LogFileNameWeight = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_Weight");
        String LogFileNameImageID = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_ImageID");
        String LogFileNameActivity = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_ActivityName");
        String LogFileNameReps = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_Reps");

        Activityname.remove(position);
        imageID.remove(position);
        Weight.remove(position);
        Reps.remove(position);

        //Redo list with ","
        StringBuilder Compiled_String_Activity = new StringBuilder();
        for (String s : Activityname) {
            Compiled_String_Activity.append(s);
            Compiled_String_Activity.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString(LogFileNameActivity, Compiled_String_Activity.toString());
        medit.commit(); //Save List even after app is closed

        StringBuilder Compiled_String_ImageID = new StringBuilder();
        for (Integer s : imageID) {
            Compiled_String_ImageID.append(s.toString());
            Compiled_String_ImageID.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref_ImageID = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit_ImageID = sharedpref_ImageID.edit();
        medit_ImageID.putString(LogFileNameImageID, Compiled_String_ImageID.toString());
        medit_ImageID.commit(); //Save List even after app is closed

        StringBuilder Compiled_String_Weight = new StringBuilder();
        for (String s : Weight) {
            Compiled_String_Weight.append(s);
            Compiled_String_Weight.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref_Weight = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit_Weight = sharedpref_Weight.edit();
        medit_Weight.putString(LogFileNameImageID, Compiled_String_ImageID.toString());
        medit_Weight.commit(); //Save List even after app is closed

        StringBuilder Compiled_String_Reps = new StringBuilder();
        for (String s : Reps) {
            Compiled_String_Reps.append(s);
            Compiled_String_Reps.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref_Reps = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit_Reps = sharedpref_Reps.edit();
        medit_Reps.putString(LogFileNameReps, Compiled_String_Reps.toString());
        medit_Reps.commit(); //Save List even after app is closed]

        workouts_list_adapter.SetListEntries(this, Activityname, imageID, Weight, Reps);
        workouts_list_adapter.notifyDataSetChanged();
    }

    public void workout_selection_dialog_clicked(int position_clicked) {
        Group_Clicked = position_clicked;
        final AlertDialog newFragbuilder = new AlertDialog.Builder(this).create();
        final View DialogView = getLayoutInflater().inflate(R.layout.custom_list_item_image_text, null);

        List<String> list = new ArrayList<>();
        String[] Selection;
        new String();
        if (position_clicked == 0)
            Selection = Chest;
        else if (position_clicked == 1)
            Selection = Abs;
        else if (position_clicked == 2)
            Selection = Ankle;
        else if (position_clicked == 3)
            Selection = Biceps;
        else if (position_clicked == 4)
            Selection = Calves;
        else if (position_clicked == 5)
            Selection = Forearms;
        else if (position_clicked == 6)
            Selection = Glutes_Hip_Flexors;
        else if (position_clicked == 7)
            Selection = Hamstrings;
        else if (position_clicked == 8)
            Selection = Knees;
        else if (position_clicked == 9)
            Selection = Lower_Back;
        else if (position_clicked == 10)
            Selection = Middle_Back_Lats;
        else if (position_clicked == 11)
            Selection = Neck_Upper_Traps;
        else if (position_clicked == 12)
            Selection = Obliques;
        else if (position_clicked == 13)
            Selection = Quadriceps;
        else if (position_clicked == 14)
            Selection = Shoulders;
        else if (position_clicked == 15)
            Selection = Spine;
        else if (position_clicked == 16)
            Selection = Triceps;
        else if (position_clicked == 17)
            Selection = Upper_Back_Lower_Traps;
        else if (position_clicked == 18)
            Selection = Wrists;
        else if (position_clicked == 19)
            Selection = Cardio;
        else if (position_clicked == 20)
            Selection = Exercise_Break;
        else
            Selection = null;

        for (int i = 0; i < Selection.length; i++) {
            list.add(Selection[i]);
        }

        ListView Workouts_Individual_List = (ListView) DialogView.findViewById(R.id.Workouts_Individual_Contents_List);
        ArrayAdapter Workouts_Individual_Adapter = new ArrayAdapter<String>(this, R.layout.text_date_list, R.id.item2, list);
        Workouts_Individual_List.setAdapter(Workouts_Individual_Adapter);

        newFragbuilder.setView(DialogView);
        newFragbuilder.show();
        Workouts_Individual_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                newFragbuilder.dismiss();
                Workout_Item_clicked(position);
            }
        });

    }

    public void Workout_Item_clicked(final int position) {
        final String workouts_title;
        final int image_id;
        final AlertDialog newFragbuilder = new AlertDialog.Builder(this).create();
        final View weight_reps_fab_entry_view = getLayoutInflater().inflate(R.layout.weight_reps_fab_dialog, null);
        ImageView workout_image = (ImageView) weight_reps_fab_entry_view.findViewById(R.id.dialog_image);
        final EditText reps = (EditText) weight_reps_fab_entry_view.findViewById(R.id.reps_entry);
        final EditText weight = (EditText) weight_reps_fab_entry_view.findViewById(R.id.weight_entry);
        Button cancel = (Button) weight_reps_fab_entry_view.findViewById(R.id.cancel_button);
        Button ok = (Button) weight_reps_fab_entry_view.findViewById(R.id.ok_button);

        if (Group_Clicked == 0) {
            workouts_title = Chest[position];
            image_id = Chests_Int[position];
            workout_image.setImageResource(Chests_Int[position]);
        } else if (Group_Clicked == 1) {
            workouts_title = Abs[position];
            image_id = Abs_Int[position];
            workout_image.setImageResource(Abs_Int[position]);
        } else if (Group_Clicked == 2) {
            workouts_title = Ankle[position];
            image_id = Ankle_Int[position];
            workout_image.setImageResource(Ankle_Int[position]);
        } else if (Group_Clicked == 3) {
            workouts_title = Biceps[position];
            image_id = Biceps_Int[position];
            workout_image.setImageResource(Biceps_Int[position]);
        } else if (Group_Clicked == 4) {
            workouts_title = Calves[position];
            image_id = Chests_Int[position];
            workout_image.setImageResource(Calves_Int[position]);
        } else if (Group_Clicked == 5) {
            workouts_title = Forearms[position];
            image_id = Forearms_Int[position];
            workout_image.setImageResource(Forearms_Int[position]);
        } else if (Group_Clicked == 6) {
            workouts_title = Glutes_Hip_Flexors[position];
            image_id = Glutes_Hip_Flexors_Int[position];
            workout_image.setImageResource(Glutes_Hip_Flexors_Int[position]);
        } else if (Group_Clicked == 7) {
            workouts_title = Hamstrings[position];
            image_id = Hamstrings_Int[position];
            workout_image.setImageResource(Hamstrings_Int[position]);
        } else if (Group_Clicked == 8) {
            workouts_title = Knees[position];
            image_id = Knees_Int[position];
            workout_image.setImageResource(Knees_Int[position]);
        } else if (Group_Clicked == 9) {
            workouts_title = Lower_Back[position];
            image_id = Lower_Back_Int[position];
            workout_image.setImageResource(Lower_Back_Int[position]);
        } else if (Group_Clicked == 10) {
            workouts_title = Middle_Back_Lats[position];
            image_id = Middle_Back_Lats_Int[position];
            workout_image.setImageResource(Middle_Back_Lats_Int[position]);
        } else if (Group_Clicked == 11) {
            workouts_title = Neck_Upper_Traps[position];
            image_id = Neck_Upper_Traps_Int[position];
            workout_image.setImageResource(Neck_Upper_Traps_Int[position]);
        } else if (Group_Clicked == 12) {
            workouts_title = Obliques[position];
            image_id = Obliques_Int[position];
            workout_image.setImageResource(Obliques_Int[position]);
        } else if (Group_Clicked == 13) {
            workouts_title = Quadriceps[position];
            image_id = Quadriceps_Int[position];
            workout_image.setImageResource(Quadriceps_Int[position]);
        } else if (Group_Clicked == 14) {
            workouts_title = Shoulders[position];
            image_id = Shoulders_Int[position];
            workout_image.setImageResource(Shoulders_Int[position]);
        } else if (Group_Clicked == 15) {
            workouts_title = Spine[position];
            image_id = Spine_Int[position];
            workout_image.setImageResource(Spine_Int[position]);
        } else if (Group_Clicked == 16) {
            workouts_title = Triceps[position];
            image_id = Triceps_Int[position];
            workout_image.setImageResource(Triceps_Int[position]);
        } else if (Group_Clicked == 17) {
            workouts_title = Upper_Back_Lower_Traps[position];
            image_id = Upper_Back_Lower_Traps_Int[position];
            workout_image.setImageResource(Upper_Back_Lower_Traps_Int[position]);
        } else if (Group_Clicked == 18) {
            workouts_title = Wrists[position];
            image_id = Wrists_Int[position];
            workout_image.setImageResource(Wrists_Int[position]);
        } else if (Group_Clicked == 19) {
            workouts_title = Cardio[position];
            image_id = Cardio_Int[position];
            workout_image.setImageResource(Cardio_Int[position]);
        } else if (Group_Clicked == 20) {
            workouts_title = Exercise_Break[position];
            image_id = Exercise_Break_Int[position];
            workout_image.setImageResource(Exercise_Break_Int[position]);
        } else{
            workouts_title = null;
            image_id = 0;
        }


            newFragbuilder.setView(weight_reps_fab_entry_view);
            newFragbuilder.show();
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Integer repsInt = Integer.parseInt(reps.getText().toString());
                    Integer weightInt = Integer.parseInt(weight.getText().toString());

                    saveListEntries(workouts_title, image_id, ("Workout Reps: "+ repsInt.toString()), ("Weight/Resistance: " + weightInt.toString()));
                    newFragbuilder.dismiss();

                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    newFragbuilder.dismiss();
                }
            });
            workouts_list_adapter.SetListEntries(this, Activityname, imageID, Weight, Reps);
            workouts_list_adapter.notifyDataSetChanged();
        }

    public void saveListEntries(String activityName, Integer image_id, String reps, String weight) {
        String LogFileNameWeight = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_Weight");
        String LogFileNameImageID = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_ImageID");
        String LogFileNameActivity = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_ActivityName");
        String LogFileNameReps = ("HomeView_" + MainActivity.Home_List_Member_Clicked + "_DateView_" +
                (Date_View_Activity.date_position_name) + "_Reps");

        Activityname.add(activityName);
        imageID.add(image_id);
        Weight.add(weight);
        Reps.add(reps);

        //Redo list with ","
        StringBuilder Compiled_String_Activity = new StringBuilder();
        for (String s : Activityname) {
            Compiled_String_Activity.append(s);
            Compiled_String_Activity.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit = sharedpref.edit();
        medit.putString(LogFileNameActivity, Compiled_String_Activity.toString());
        medit.commit(); //Save List even after app is closed

        StringBuilder Compiled_String_ImageID = new StringBuilder();
        for (Integer s : imageID) {
            Compiled_String_ImageID.append(s.toString());
            Compiled_String_ImageID.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref_ImageID = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit_ImageID = sharedpref_ImageID.edit();
        medit_ImageID.putString(LogFileNameImageID, Compiled_String_ImageID.toString());
        medit_ImageID.commit(); //Save List even after app is closed

        StringBuilder Compiled_String_Weight = new StringBuilder();
        for (String s : Weight) {
            Compiled_String_Weight.append(s);
            Compiled_String_Weight.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref_Weight = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit_Weight = sharedpref_Weight.edit();
        medit_Weight.putString(LogFileNameWeight, Compiled_String_Weight.toString());
        medit_Weight.commit(); //Save List even after app is closed

        StringBuilder Compiled_String_Reps = new StringBuilder();
        for (String s : Reps) {
            Compiled_String_Reps.append(s);
            Compiled_String_Reps.append(",");
        }

        //Update shared preferences to save list on main activity activity
        SharedPreferences sharedpref_Reps = getSharedPreferences("Home_View_List_Saved", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor medit_Reps = sharedpref_Reps.edit();
        medit_Reps.putString(LogFileNameReps, Compiled_String_Reps.toString());
        medit_Reps.commit(); //Save List even after app is closed]

        workouts_list_adapter.SetListEntries(this, Activityname, imageID, Weight, Reps);
        workouts_list_adapter.notifyDataSetChanged();
    }


}
